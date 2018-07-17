package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.game.BulletManager;
import com.missionbit.game.ObstacleManager;
import com.missionbit.game.Player;

public class PlayState extends State {
    private OrthographicCamera camera;
    private SpriteBatch myBatch;
    private Player player1;
    private Player player2;
    private Texture background;
    private BulletManager manager;
    private ObstacleManager obstacleManager;

   public PlayState(GameStateManager gsm) {
       super(gsm);
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
   }

    @Override
    protected void handleInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player1.shoot(manager, 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            player2.shoot(manager, -1);
        }
    }

    @Override
    public void update(float dt){
       handleInput();
    }

    @Override
    public void render(SpriteBatch myBatch) {
        //Set up our camera
        camera.update();
        myBatch.setProjectionMatrix(camera.combined);

        myBatch.begin();

        myBatch.draw(background, 0, 0);
        player2.updown(myBatch);
        player1.ws(myBatch);
        player1.draw(myBatch);
        player2.draw(myBatch);

        myBatch.end();

        manager.update(player1, player2, obstacleManager);
        manager.draw(camera);

        obstacleManager.update();
        obstacleManager.draw();
    }

    @Override
    public void dispose () {
        myBatch.dispose();
    }
}

