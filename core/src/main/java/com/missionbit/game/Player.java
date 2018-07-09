package com.missionbit.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private Sprite myImage;

    private Vector2 velocity;
    private float speed;



    public Player(int startx,int starty,String imagepath) {
        myImage = new Sprite(new Texture(Gdx.files.internal(imagepath)));

        myImage.setX(startx);
        myImage.setY(starty);


        velocity = new Vector2( 0,  0);
        speed = 230.0f;

        //bulletsP1 = new ArrayList<Bullet>();

    }
    public void draw(SpriteBatch myBatch){

        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            myImage.setY(myImage.getY() + speed * Gdx.graphics.getDeltaTime());
            //System.out.println("im inside the if statement");

        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            myImage.setY(myImage.getY() - speed * Gdx.graphics.getDeltaTime());
        }




//        }

        if(myImage.getY() < 0){
            myImage.setY(0);
            velocity.y *= -1;
        }

//
//        }

        if(myImage.getY() + myImage.getHeight() > Gdx.graphics.getHeight()){
            myImage.setY(Gdx.graphics.getHeight()-myImage.getHeight());
            velocity.y *= -1;
        }


        myImage.draw(myBatch);
        //myBatch.draw(myImage, (int)velocity.x, (int)velocity.y);

    }

    public void updown(SpriteBatch myBatch){

        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            myImage.setY(myImage.getY() + speed * Gdx.graphics.getDeltaTime());
            //System.out.println("im inside the if statement");

        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            myImage.setY(myImage.getY() - speed * Gdx.graphics.getDeltaTime());
        }
        if(myImage.getY() < 0){
            myImage.setY(0);
            velocity.y *= -1;
        }
        if(myImage.getY() + myImage.getHeight() > Gdx.graphics.getHeight()){
            myImage.setY(Gdx.graphics.getHeight()-myImage.getHeight());
            velocity.y *= -1;
        }
        myImage.draw(myBatch);

    }

    public void ws(SpriteBatch myBatch){

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            myImage.setY(myImage.getY() + speed * Gdx.graphics.getDeltaTime());
            //System.out.println("im inside the if statement");

        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            myImage.setY(myImage.getY() - speed * Gdx.graphics.getDeltaTime());
        }
        if(myImage.getY() < 0){
            myImage.setY(0);
            velocity.y *= -1;
        }
        if(myImage.getY() + myImage.getHeight() > Gdx.graphics.getHeight()){
            myImage.setY(Gdx.graphics.getHeight()-myImage.getHeight());
            velocity.y *= -1;
        }
        myImage.draw(myBatch);

    }

    public Bullet shoot(int right) {
        Bullet b = new Bullet(myImage.getX(),myImage.getY(), right);
        return b;


    }



}