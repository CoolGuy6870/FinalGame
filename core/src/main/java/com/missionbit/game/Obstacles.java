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
  //  private Sprite myImage2;
    private Vector2 velocity;
    private SpriteBatch myBatch;
    private ParticleEffect effect;
    private boolean alive = true;
    private Vector2 velocity2;
    private String []imageNames = {"tree.png", "rock.png"};


    //This goes in the body of our class
    public Obstacles(SpriteBatch batch) {
        myBatch = batch;
        String path = imageNames[MathUtils.random(imageNames.length-1)];
        myImage = new Sprite(new Texture(Gdx.files.internal(path)));
        //myImage2 = new Sprite(new Texture(Gdx.files.internal("rock.png")));

        velocity = new Vector2(MathUtils.random() * 200, MathUtils.random() * 200);
        velocity2 = new Vector2(MathUtils.random()*200,  MathUtils.random()*200);
    }

    public void update() {

        float xPos = myImage.getX() + velocity.x * Gdx.graphics.getDeltaTime();
        float yPos = myImage.getY() + velocity.y * Gdx.graphics.getDeltaTime();
        //float xPos2 = myImage2.getX() + velocity2.x * Gdx.graphics.getDeltaTime();
    //    float yPos2 = myImage2.getY() + velocity2.y * Gdx.graphics.getDeltaTime();

        myImage.setX(xPos);
        myImage.setY(yPos);

       // myImage2.setX(xPos2);
        //myImage2.setY(yPos2);

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


  //      if (myImage2.getX() < 230) {
    //        myImage2.setX(230);
            //velocity2.x *= -1;
       // }
//        if (myImage2.getY() < 0) {
//            myImage2.setY(0);
            //velocity2.y *= -1;
//        }
//        if (myImage2.getX() > 675) {
//            myImage2.setX(675);
//            velocity2.x *= -1;
//        }
//        if (myImage2.getY() + myImage2.getHeight() > Gdx.graphics.getHeight()) {
//            myImage2.setY(Gdx.graphics.getHeight() - myImage2.getHeight());
//            velocity2.y *= -1;
//        }

    }
    public void handleHit(Bullet b) {

        if(b.getBoundingRectangle().overlaps(myImage.getBoundingRectangle())) {

            System.out.print("obstacle was hit");
            b.setZero();
            b.setActive(false);
            velocity.setZero();
            myImage.setAlpha(0);

            alive = false;
        }
//        else if(b.getBoundingRectangle().overlaps(myImage2.getBoundingRectangle())){
//
//            System.out.print("obstacle was hit");
//            b.setZero();
//            b.setActive(false);
//            velocity2.setZero();
//            myImage2.setAlpha(0);
//            alive = false;
//        }
    }

    public void draw() {
        if (alive) {
            myImage.draw(myBatch);
           // myImage2.draw(myBatch);
        }
    }

    public boolean getAlive(){
        return alive;
    }

}


