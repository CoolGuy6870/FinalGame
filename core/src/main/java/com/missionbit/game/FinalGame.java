package com.missionbit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Random;

public class FinalGame extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Random randomSource;
    private SpriteBatch myBatch;
    ///private Vector2 velocity;
    private Player player1;
    private Player player2;
    private Texture background;
   // private ArrayList<Obstacles> obstacles;
//    private ArrayList<Bullet> bulletsP1 ;
    private int count;

    private BulletManager manager;

    private ObstacleManager obstacleManager;




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
        manager = new BulletManager();
        obstacleManager = new ObstacleManager();

        obstacleManager.add();

//        obstacles = new ArrayList<Obstacles>();
//        bulletsP1 = new ArrayList<Bullet>();

//        for (int i = 0; i < 3; i++) {
//            Obstacles f = new Obstacles(myBatch);
//            Obstacles r = new Obstacles(myBatch);
//            obstacles.add(f);
//            obstacles.add(r);
//        }



        }


    @Override
    public void render() {
        //Set up our camera
        camera.update();
        myBatch.setProjectionMatrix(camera.combined);

        //TODO: Draw our image!

        myBatch.begin();
        myBatch.draw(background, 0, 0);
        player2.updown(myBatch);
        player1.ws(myBatch);
        player1.draw(myBatch);
        player2.draw(myBatch);

        obstacleManager.draw();

//        for (Obstacles f : obstacles) {
//            f.update();
//            f.draw();
//
//        }





        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//
            player1.shoot(manager, 1);
            //bulletsP1.add(player1.shoot(1));
            //manager.spawnBullet(player1.getX(),player1.getY(), 1);

        }

        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {

            player2.shoot(manager, -1);
//            if(System.currentTimeMillis()- lastSpawn > 500) {
//               // bulletsP1.add(manager.spawnBullet(player2.getX(),player2.getY(), -1));
//                manager.spawnBullet(player2.getX(),player2.getY(), -1);
//                lastSpawn = System.currentTimeMillis();
//            }
            //bulletsP1.add(player2.shoot(-1));
            //manager.spawnBullet(player2.getX(),player2.getY(), -1);



        }
        camera.update();
        manager.update(player1, player2, obstacleManager);
        obstacleManager.update();
        manager.draw(camera);

//        for(Bullet bullet : bulletsP1){
//            if (bullet != null) {
//                bullet.update();
//                bullet.draw(myBatch);
//
//            }
//            player1.handleHit(bullet);
//            player2.handleHit(bullet);
//        }

        myBatch.end();
        }

        @Override
        public void dispose () {
            myBatch.dispose();
        }
}

