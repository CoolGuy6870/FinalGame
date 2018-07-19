package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.missionbit.game.BulletManager;
import com.missionbit.game.ObstacleManager;
import com.missionbit.game.Player;

public class PlayState extends State {
    //private OrthographicCamera camera;
    private SpriteBatch myBatch;
    private Player player1;
    private Player player2;
    private Texture background;
    private BulletManager manager;
    private ObstacleManager obstacleManager;
    private Sprite upButton1;
    private Sprite shootButton1;
    private Sprite downButton1;
    private Sprite upButton2;
    private Sprite shootButton2;
    private Sprite downButton2;



   public PlayState(GameStateManager gsm) {
       super(gsm);
        background = new Texture("background.png");

        // Set up camera for 2d view of 800x480 pixels
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 960, 540);

        // Create a sprite batch for rendering our image
        myBatch = new SpriteBatch();
        player1 = new Player(140, 270, "Player 1.gif");
        player2 = new Player(755, 270, "Player 2.gif");
        manager = new BulletManager();
        obstacleManager = new ObstacleManager();
        obstacleManager.add();

       upButton1 = new Sprite(new Texture(Gdx.files.internal("p1upbutton.gif")));
       upButton1.setX(15);
       upButton1.setY(420);

       shootButton1 = new Sprite(new Texture(Gdx.files.internal("p1shootbutton.gif")));
       shootButton1.setX(15);
       shootButton1.setY(220);

       downButton1 = new Sprite(new Texture(Gdx.files.internal("p1downbutton.gif")));
       downButton1.setX(15);
       downButton1.setY(25);

       upButton2 = new Sprite(new Texture(Gdx.files.internal("p2upbutton.gif")));
       upButton2.setX(865);
       upButton2.setY(420);

       shootButton2 = new Sprite(new Texture(Gdx.files.internal("p2shootbutton.gif")));
       shootButton2.setX(865);
       shootButton2.setY(220);

       downButton2 = new Sprite(new Texture(Gdx.files.internal("p2downbutton.gif")));
       downButton2.setX(865);
       downButton2.setY(25);





   }

    @Override
    protected void handleInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player1.shoot(manager, 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            player2.shoot(manager, -1);
        }

        if (Gdx.input.justTouched()) {
            Vector3 touchPosition = new Vector3();
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touchPosition);
            //System.out.println(downButton1.getBoundingRectangle() + " " + touchPosition);

            //if (upButton1.getBoundingRectangle().contains(touchPosition.x, touchPosition.y)) {

            //}
            if (shootButton1.getBoundingRectangle().contains(touchPosition.x, touchPosition.y)) {
                player1.shoot(manager, 1);
            }
            //if (downButton1.getBoundingRectangle().contains(touchPosition.x, touchPosition.y)) {

            //}

            //if (upButton2.getBoundingRectangle().contains(touchPosition.x, touchPosition.y)) {

            //}

            if (shootButton2.getBoundingRectangle().contains(touchPosition.x, touchPosition.y)) {
                player2.shoot(manager, -1);
            }
            //if (upButton1.getBoundingRectangle().contains(touchPosition.x, touchPosition.y)) {

                //}
        }
    }

    @Override
    public void update(float dt){
       handleInput();
    }

    @Override
    public void render(SpriteBatch myBatch) {
        //Set up our camera
        cam.update();
        myBatch.setProjectionMatrix(cam.combined);

        myBatch.begin();

        myBatch.draw(background, 0, 0);
        player2.updown(myBatch);
        player1.ws(myBatch);
        player1.draw(myBatch);
        player2.draw(myBatch);
        upButton1.draw(myBatch);
        shootButton1.draw(myBatch);
        downButton1.draw(myBatch);
        upButton2.draw(myBatch);
        shootButton2.draw(myBatch);
        downButton2.draw(myBatch);


        myBatch.end();

        manager.update(player1, player2, obstacleManager);
        manager.draw(cam);

        obstacleManager.update();
        obstacleManager.draw();


    }

    @Override
    public void dispose () {
        myBatch.dispose();
    }
}


