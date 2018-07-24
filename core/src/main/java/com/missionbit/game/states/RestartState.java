package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RestartState extends State {

    private Texture RestartScreen;
    public RestartState(GameStateManager gsm, int right){
        super(gsm);
        if(right == 1) {
            RestartScreen = new Texture(Gdx.files.internal("EndScreenP2.gif"));
        }
        else{
            RestartScreen = new Texture(Gdx.files.internal("EndScreenP1.gif"));
        }

    }
    protected void handleInput(){
        if(Gdx.input.justTouched()){
            gsm.set(new MenuState(gsm));

        }
    }





    public void update(float dt){
        handleInput();

    }





    public void render(SpriteBatch sb){

        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(RestartScreen, 0, 0, RestartScreen.getWidth(), RestartScreen.getHeight());
        sb.end();
    }





    public void dispose(){
        RestartScreen.dispose();
        System.out.println("disposing restart state");

    }
}
