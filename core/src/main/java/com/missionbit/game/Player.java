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
    private ParticleEffect effects;
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
            //bulletsP1.add(manager.spawnBullet(player1.getX(),player1.getY(), 1));
            if(  right == 1) {
                manager.spawnBullet(getX() + myImage.getWidth() + 1, getY() + 5, right);
            }

            else if (right == -1) {
                manager.spawnBullet(getX() - 10, getY() + 5, right);
            }
                bulletSpawn = System.currentTimeMillis();

        }
    }

//    public void draw(SpriteBatch myBatch) {
//
//        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
//            myImage.setY(myImage.getY() + speed * Gdx.graphics.getDeltaTime());
//            //System.out.println("im inside the if statement");
//
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
//            myImage.setY(myImage.getY() - speed * Gdx.graphics.getDeltaTime());
//        }
//
//
//        if (myImage.getY() < 0) {
//            myImage.setY(0);
//            velocity.y *= -1;
//        }
//
//
//        if (myImage.getY() + myImage.getHeight() > Gdx.graphics.getHeight()) {
//            myImage.setY(Gdx.graphics.getHeight() - myImage.getHeight());
//            velocity.y *= -1;
//        }
//
//
//        myImage.draw(myBatch);
        //myBatch.draw(myImage, (int)velocity.x, (int)velocity.y);

    //}

    public void updown(SpriteBatch myBatch) {

        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            myImage.setY(myImage.getY() + speed * Gdx.graphics.getDeltaTime());
            //System.out.println("im inside the if statement");

        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            myImage.setY(myImage.getY() - speed * Gdx.graphics.getDeltaTime());
        }
        if (myImage.getY() < 0) {
            myImage.setY(0);
            velocity.y *= -1;
        }
        if (myImage.getY() + myImage.getHeight() > Gdx.graphics.getHeight()) {
            myImage.setY(Gdx.graphics.getHeight() - myImage.getHeight());
            velocity.y *= -1;
        }


    }

    public void ws(SpriteBatch myBatch) {

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            myImage.setY(myImage.getY() + speed * Gdx.graphics.getDeltaTime());
            //System.out.println("im inside the if statement");

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            myImage.setY(myImage.getY() - speed * Gdx.graphics.getDeltaTime());
        }
        if (myImage.getY() < 0) {
            myImage.setY(0);
            velocity.y *= -1;
        }
        if (myImage.getY() + myImage.getHeight() > Gdx.graphics.getHeight()) {
            myImage.setY(Gdx.graphics.getHeight() - myImage.getHeight());
            velocity.y *= -1;
        }


    }

//    public Bullet shoot(int right) {
//        Bullet b = new Bullet(myImage.getX(), myImage.getY(), right);
//        return b;
//
//
//    }

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
           // System.out.println("boom");
        }
    }

    public void handleHit(Bullet b) {
//        boolean hit = myImage.getBoundingRectangle().contains(b.getX() + b.getWidth() / 2.0f, b.getY() + b.getHeight() / 2.0f);
//        if(hit){
//            myImage.setColor(1,0,0,1);
//            b.setActive(false);


          if(b.getBoundingRectangle().overlaps(myImage.getBoundingRectangle())) {

//        if (b.getX() + b.getWidth() > myImage.getX()) {
//            if (b.getY() + b.getHeight() < myImage.getY() + myImage.getHeight() && b.getY() + b.getHeight() > myImage.getY()) {
                effects.setPosition(myImage.getX() + myImage.getWidth() / 2.0f, myImage.getY() + myImage.getHeight() / 2.0f);
////                effect.start();
                System.out.print("hit!");
                effects.start();
//                myImage.setColor(1, 0, 0, 1);
                b.setZero();
                b.setActive(false);
                alive = false;


            //}
        }
    }

}



