package com.missionbit.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Obstacles {

    private Sprite myImage;
    private Sprite myImage2;
    private Vector2 velocity;
    private SpriteBatch myBatch;
    private ParticleEffect effect;
    private boolean alive = true;


    //This goes in the body of our class
    public Obstacles(SpriteBatch batch) {
        myBatch = batch;
        myImage = new Sprite(new Texture(Gdx.files.internal("tree.png")));
        myImage2 = new Sprite(new Texture(Gdx.files.internal("rock.png")));


//        effect = new ParticleEffect();
//        effect.load(Gdx.files.internal("effects/explode.p"), Gdx.files.internal("images"));

        velocity = new Vector2(MathUtils.random() * -200, MathUtils.random() * 200);
    }

    public void update() {


        float xPos = myImage.getX() + velocity.x * Gdx.graphics.getDeltaTime();
        float yPos = myImage.getY() + velocity.y * Gdx.graphics.getDeltaTime();


        myImage.setX(xPos);
        myImage.setY(yPos);
        myImage2.setX(xPos);
        myImage2.setY(yPos);

        Gdx.graphics.getWidth();
        Gdx.graphics.getHeight();

        if (myImage.getX() < 230) {
            myImage.setX(230);
            velocity.x *= -1;
        }

        if (myImage.getY() < 0) {
            myImage.setY(0);
            velocity.y *= -1;
        }




        if (myImage.getX() > 660) {
            myImage.setX(660);
            velocity.x *= -1;
        }

        if (myImage.getY() + myImage.getHeight() > Gdx.graphics.getHeight()) {
            myImage.setY(Gdx.graphics.getHeight() - myImage.getHeight());
            velocity.y *= -1;
        }
    }

    public void draw() {
        if (alive) {
            myImage.draw(myBatch);
        } else {
            effect.draw(myBatch, Gdx.graphics.getDeltaTime());
        }
    }
}


