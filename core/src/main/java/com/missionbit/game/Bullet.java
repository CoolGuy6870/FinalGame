//package com.missionbit.game;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.math.MathUtils;
//
//public class Bullet {
//
//    private float lifeTime;
//    private float lifeTimer;
//    private float x;
//    private float y;
//    private float radians;
//    private float dx;
//    private float dy;
//    private float width;
//    private float height;
//    private Texture wrap;
//    private boolean remove;
//
//
//    public Bullet(float x, float y, float radians) {
//
//        this.x = x;
//        this.y = y;
//        this.radians = radians;
//
//        float speed = 150;
//        dx = MathUtils.cos(radians) * speed;
//        dy = MathUtils.sin(radians) * speed;
//
//        width = height = 2;
//
//        lifeTimer = 0;
//        lifeTimer = 1;
//
//    }
//
//    public boolean shouldRemove() { return remove; }
//
//    public void update(float dt) {
//
//        x += dx * dt;
//        y += dy * dt;
//
//        wrap();
//
//        lifeTimer += dt;
//        if(lifeTimer > lifeTime) {
//            remove = true;
//        }
//
//        {
//
//        }
//    }
//
//
//}

package com.missionbit.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Bullet {
    //private SpriteBatch myBatch;
    private Sprite myImage;
    private Vector2 velocity;
    private boolean alive = true;
    private ParticleEffect effect;


    public Bullet(float x, float y, int right) {
        //myBatch = batch;
        myImage = new Sprite(new Texture(Gdx.files.internal("bullet.gif")));

        myImage.setX(x - 22);
        myImage.setY(y - 22);

        velocity = new Vector2(60 * right, 0);



    }

    public void update() {

        

        float xPos = myImage.getX() + velocity.x * Gdx.graphics.getDeltaTime();
        float yPos = myImage.getY() + velocity.y * Gdx.graphics.getDeltaTime();

        myImage.setX(xPos);
        myImage.setY(yPos);

        Gdx.graphics.getWidth();
        Gdx.graphics.getHeight();
    }

    public void draw(SpriteBatch myBatch) {
        if (alive) {
            myImage.draw(myBatch);
        } else {
            effect.draw(myBatch, Gdx.graphics.getDeltaTime());
        }
    }
}
