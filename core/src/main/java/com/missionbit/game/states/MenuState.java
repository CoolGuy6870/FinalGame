package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;



/**
 * Created by missionbit on 6/20/17.
 */

public class MenuState extends State {
    private Texture background;
    private Rectangle playBtn;
    private Vector3 touchPosition;
    //private ShapeRenderer renderer;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("Start Screen.gif");
        playBtn = new Rectangle(386,  93, 156, 62);
        //renderer = new ShapeRenderer();

       // cam.setToOrtho(false, 960, 540);
    }

    @Override
    public void handleInput() {
       if (Gdx.input.justTouched()) {
           touchPosition = new Vector3();
           touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
           cam.unproject(touchPosition);

           if(playBtn.contains(touchPosition.x, touchPosition.y)) {
               gsm.set(new PlayState(gsm));
           }
       }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0);
        update(Gdx.graphics.getDeltaTime());
        sb.end();

//        renderer.setProjectionMatrix(cam.combined);
//        renderer.begin(ShapeRenderer.ShapeType.Line);
//        renderer.setColor(1,0,0,1);
//        renderer.rect(playBtn.x, playBtn.y, playBtn.width, playBtn.height);
//        renderer.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        System.out.println("Disposing of Menu State");
    }
}
