package com.missionbit.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Player {
    private Sprite myImage;
    private Vector2 velocity;

    public Player(int startx,int starty) {
        myImage = new Sprite(new Texture(Gdx.files.internal("player.jpg")));
        myImage.setX(startx);
        myImage.setY(starty);

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