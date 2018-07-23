package com.missionbit.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxBuild;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    //private Sprite myImage;
    private Animation<TextureRegion> playerAnimation;
    private Vector2 position;
    private Rectangle rectangle;
    private float animationTime;

    private Vector2 velocity;
    private float speed;
    public ParticleEffect effects;
    private long bulletSpawn;
    protected boolean alive = true;



    public Player(int startx, int starty, String imagepath) {
        //myImage = new Sprite(new Texture(Gdx.files.internal(imagepath)));
        playerAnimation = Utils.LoadAnimation(imagepath,2,2,4,0.2f);


        //myImage.setX(startx);
        //myImage.setY(starty);
        position = new Vector2();
        position.x = startx;
        position.y = starty;
        rectangle = new Rectangle();
        velocity = new Vector2(0, 0);
        speed = 230.0f;

        bulletSpawn = System.currentTimeMillis();
//
        effects = new ParticleEffect();
        effects.load(Gdx.files.internal("effects/explode.p"), Gdx.files.internal("images"));
    }

    public void shoot(BulletManager manager, int right){
        if(System.currentTimeMillis()- bulletSpawn > 500) {

            animationTime = 0;

            if(  right == 1) {
                manager.spawnBullet(getX() + getWidth() + 1, getY() + 5, right);
            }

            else if (right == -1) {
                manager.spawnBullet(getX() - 10, getY() + 5, right);
            }
                bulletSpawn = System.currentTimeMillis();

        }
    }


    public void moveUp() {

        //myImage.setY(myImage.getY() + speed * Gdx.graphics.getDeltaTime());
        position.y = position.y + speed * Gdx.graphics.getDeltaTime();

        if (position.y + getHeight() > Gdx.graphics.getHeight()) {
            position.y = (Gdx.graphics.getHeight() - getHeight());
            velocity.y *= -1;
        }
    }

    public void moveDown() {

        position.y = (position.y - speed * Gdx.graphics.getDeltaTime());

        if (position.y < 0) {
            position.y = 0;
            velocity.y *= -1;
        }

    }

    public float getX() {
        return position.x;

    }

    public float getY() {
        return position.y;
    }

    public void draw(SpriteBatch myBatch){
        if(alive) {
            //myImage.draw(myBatch);
            TextureRegion frame = playerAnimation.getKeyFrame(animationTime,false);
            myBatch.draw(frame,position.x,position.y);
            animationTime += Gdx.graphics.getDeltaTime();
        }
        else{
            effects.draw(myBatch, Gdx.graphics.getDeltaTime());

        }
    }

    public void handleHit(Bullet b) {



          if(b.getBoundingRectangle().overlaps(getRect())) {
                effects.setPosition(position.x + getWidth() / 2.0f, position.y + getHeight() / 2.0f);
                System.out.print("hit!");
                effects.start();
                b.setZero();
                b.setActive(false);
                alive = false;

                position.y = 9999;
                position.x = 9999;



        }
    }
    public boolean isAlive(){
        return alive;
    }

    public int getWidth(){
        return playerAnimation.getKeyFrame(0).getRegionWidth();
    }
    public int getHeight(){
        return playerAnimation.getKeyFrame(0).getRegionHeight();
    }
    public Rectangle getRect(){
        TextureRegion region = playerAnimation.getKeyFrame(0);
        rectangle.x = position.x;
        rectangle.y = position.y;
        rectangle.width = region.getRegionWidth();
        rectangle.height = region.getRegionHeight();
        return rectangle;
    }


}



