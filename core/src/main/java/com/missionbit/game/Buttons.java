package com.missionbit.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Buttons {
    private Sprite myImage;

    private Vector2 velocity;
    private float speed;
    private ParticleEffect effects;
    private long bulletSpawn;
    protected boolean alive = true;
}

    public void updown(SpriteBatch myBatch) {


        if (Gdx.input.isKeyPressed(Input.Keys.)) {
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





