package com.missionbit.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Player {
    private Sprite myImage;
    //private Sprite myImage2;
    private Vector2 velocity;

    public Player(int startx,int starty,String imagepath) {
        myImage = new Sprite(new Texture(Gdx.files.internal(imagepath)));
        //myImage2 = new Sprite(new Texture(Gdx.files.internal("Player 2.gif")));
        myImage.setX(startx);
        myImage.setY(starty);
        //myImage2.setX(startx);
        //myImage2.setY(starty);

        velocity = new Vector2( 0,  100);

    }
    public void draw(SpriteBatch myBatch){
        float xPos = myImage.getX() + velocity.x * Gdx.graphics.getDeltaTime();
        float yPos = myImage.getY() + velocity.y * Gdx.graphics.getDeltaTime();

        myImage.setX(xPos);
        myImage.setY(yPos);


        myImage.draw(myBatch);

    }
    public int getWidth(){
        return (int)myImage.getWidth();
    }
    public void setx(float x){
        myImage.setX(x);
    }
}