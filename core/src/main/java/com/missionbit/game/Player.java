package com.missionbit.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxBuild;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private Sprite myImage;

    private Vector2 velocity;
    private float speed;
    public ParticleEffect effects;
    private long bulletSpawn;
    protected boolean alive = true;



    public Player(int startx, int starty, String imagepath) {
        myImage = new Sprite(new Texture(Gdx.files.internal(imagepath)));

        myImage.setX(startx);
        myImage.setY(starty);


        velocity = new Vector2(0, 0);
        speed = 230.0f;

        bulletSpawn = System.currentTimeMillis();
//
        effects = new ParticleEffect();
        effects.load(Gdx.files.internal("effects/explode.p"), Gdx.files.internal("images"));
    }

    public void shoot(BulletManager manager, int right){
        if(System.currentTimeMillis()- bulletSpawn > 500) {

            if(  right == 1) {
                manager.spawnBullet(getX() + myImage.getWidth() + 1, getY() + 5, right);
            }

            else if (right == -1) {
                manager.spawnBullet(getX() - 10, getY() + 5, right);
            }
                bulletSpawn = System.currentTimeMillis();

        }
    }


    public void moveUp() {

        myImage.setY(myImage.getY() + speed * Gdx.graphics.getDeltaTime());

        if (myImage.getY() + myImage.getHeight() > Gdx.graphics.getHeight()) {
            myImage.setY(Gdx.graphics.getHeight() - myImage.getHeight());
            velocity.y *= -1;
        }
    }

    public void moveDown() {

        myImage.setY(myImage.getY() - speed * Gdx.graphics.getDeltaTime());

        if (myImage.getY() < 0) {
            myImage.setY(0);
            velocity.y *= -1;
        }

    }

    public float getX() {
        return myImage.getX();

    }

    public float getY() {
        return myImage.getY();
    }

    public void draw(SpriteBatch myBatch){
        if(alive) {
            myImage.draw(myBatch);
        }
        else{
            effects.draw(myBatch, Gdx.graphics.getDeltaTime());

        }
    }

    public void handleHit(Bullet b) {



          if(b.getBoundingRectangle().overlaps(myImage.getBoundingRectangle())) {
                effects.setPosition(myImage.getX() + myImage.getWidth() / 2.0f, myImage.getY() + myImage.getHeight() / 2.0f);
                System.out.print("hit!");
                effects.start();
                b.setZero();
                b.setActive(false);
                alive = false;

                myImage.setY(9999);
                myImage.setX(9999);



        }
    }
    public boolean isAlive(){
        return alive;
    }

}



