package com.missionbit.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class BulletManager {

    private ArrayList<Bullet> activeBullets = new ArrayList<Bullet>();

    private ArrayList<Bullet> pool = new ArrayList<Bullet>();

    private ArrayList<Bullet> removed = new ArrayList<Bullet>();

    private SpriteBatch batch;
  //  private ObstacleManager manager;

    public BulletManager() {
        batch = new SpriteBatch();
      //  manager = new ObstacleManager();
    }


    public Bullet spawnBullet(float x, float y, int right){
        Bullet b;
        if(pool.isEmpty()){
            b = new Bullet(x,y,right);
            activeBullets.add(b);
            System.out.println("New");
        }
        else{
            b = pool.remove(0);
            b.reset( x,  y,  right);
            activeBullets.add(b);
            System.out.println("From Pool");
        }
        return b;

    }

    public void update( Player P1,  Player P2, ObstacleManager manager){
        for(Bullet b : activeBullets){
            b.update();

            manager.hitObstacle(b);
            P1.handleHit(b);
            P2.handleHit(b);
            if(b.getActive() == false){

                removed.add(b);
            }
        }
        activeBullets.removeAll(removed);
        pool.addAll(removed);
        removed.clear();
    }

    public void draw(Camera camera){
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(Bullet b : activeBullets){
            b.draw(batch);
        }
        batch.end();
    }

//    public void handleHit(){
//
//    }




}
