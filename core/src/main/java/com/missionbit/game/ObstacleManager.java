package com.missionbit.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class ObstacleManager {

    private ArrayList<Obstacles> obstacles;
    private SpriteBatch batch;
    private ArrayList<Obstacles> removed;

    public ObstacleManager() {
        batch = new SpriteBatch();
        obstacles = new ArrayList<Obstacles>();
        removed = new ArrayList<Obstacles>();
    }

    public void add() {
        for (int i = 0; i < 12; i++) {
            Obstacles f = new Obstacles(batch);
            obstacles.add(f);

        }
    }

    public void draw() {
        batch.begin();
        for (Obstacles f : obstacles) {
            f.update();
            f.draw();
        }
        batch.end();
    }

    public void update() {

        for (Obstacles o : obstacles) {
//           // o.update();
//            System.out.println(obstacles.size());
//            o.handleHit(b);
            if (o.getAlive() == false) {
                removed.add(o);

            }
        }
        obstacles.removeAll(removed);
        removed.clear();

    }



    public void hitObstacle(Bullet b){
        for (Obstacles o : obstacles) {
            // o.update();
            o.handleHit(b);

        }

    }
}
