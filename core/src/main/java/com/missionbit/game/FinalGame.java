package com.missionbit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

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


    @Override
    public void create() {
//        myImage = new Sprite( new Texture(Gdx.files.internal("player.jpg")));
//        myImage.setX(0);
//        myImage.setY(240);
//        randomSource = new Random();
//
//        myImage2 = new Sprite( new Texture(Gdx.files.internal("player.jpg")));
//        myImage2.setX(Gdx.graphics.getWidth()-myImage2.getWidth());
//        myImage2.setY(240);
//        randomSource = new Random();

        // Set up camera for 2d view of 800x480 pixels
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Create a sprite batch for rendering our image
        myBatch = new SpriteBatch();
        player1 = new Player(96, 240, "Player 1.gif");
        player2 = new Player(608, 240, "Player 2.gif");
        //player2.setx(Gdx.graphics.getWidth()-player2.getWidth());

        //TODO: Load our image
        // Create a random X and Y velocity
//        velocity = new Vector2( 0,  100);
    }

    @Override
    public void render() {

        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Set up our camera
        camera.update();
        myBatch.setProjectionMatrix(camera.combined);

        //TODO: Draw our image!
//        float xPos = myImage.getX() + velocity.x * Gdx.graphics.getDeltaTime();
//        float yPos = myImage.getY() + velocity.y * Gdx.graphics.getDeltaTime();
//
//        myImage.setX(xPos);
//        myImage.setY(yPos);

//        xPos = myImage2.getX() + velocity.x * Gdx.graphics.getDeltaTime();
//        yPos = myImage2.getY() + velocity.y * Gdx.graphics.getDeltaTime();
//
//        myImage2.setX(xPos);
//        myImage2.setY(yPos);

        myBatch.begin();
        player2.updown(myBatch);
        player1.ws(myBatch);
//        myImage.draw(myBatch);
//        myImage2.draw(myBatch);
        myBatch.end();
    }

    @Override
    public void dispose() {
        myBatch.dispose();
    }
}