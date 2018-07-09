package com.missionbit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Random;

public class FinalGame extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Random randomSource;
    private Sprite myImage;
    private Sprite myImage2;
    private SpriteBatch myBatch;
    ///private Vector2 velocity;
    private Player player1;
    private Player player2;
    private Texture background;
    private ArrayList<Obstacles> obstacles;
    private ArrayList<Bullet> bulletsP1 ;
    private int count;




    @Override
    public void create() {

        background = new Texture("background.png");


        // Set up camera for 2d view of 800x480 pixels
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 540);

        // Create a sprite batch for rendering our image
        myBatch = new SpriteBatch();
        player1 = new Player(140, 270, "Player 1.gif");
        player2 = new Player(755, 270, "Player 2.gif");

        obstacles = new ArrayList<Obstacles>();
        bulletsP1 = new ArrayList<Bullet>();

        for (int i = 0; i < 3; i++) {
            Obstacles f = new Obstacles(myBatch);
            Obstacles r = new Obstacles(myBatch);
            obstacles.add(f);
            obstacles.add(r);

        }



        }



        //TODO: Load our image
        // Create a random X and Y velocity
//        velocity = new Vector2( 0,  100);


    @Override
    public void render() {

        // Clear the screen



        //Set up our camera
        camera.update();
        myBatch.setProjectionMatrix(camera.combined);

        //TODO: Draw our image!



        myBatch.begin();
        myBatch.draw(background, 0, 0);
        player2.updown(myBatch);
        player1.ws(myBatch);
        for (Obstacles f : obstacles) {
            f.update();
            f.draw();



    }



                if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                    bulletsP1.add(player1.shoot(1));

                }

                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
                    bulletsP1.add(player2.shoot(-1));

                }

                for(Bullet bullet : bulletsP1){
                    if (bullet != null) {
                        bullet.update();
                        bullet.draw(myBatch);
                    }
                }

        myBatch.end();


        }

        @Override
        public void dispose () {
            myBatch.dispose();
        }
}

