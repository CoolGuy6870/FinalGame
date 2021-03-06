package com.missionbit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.game.states.GameStateManager;
import com.missionbit.game.states.MenuState;
import com.missionbit.game.states.PlayState;

public class FinalGame extends ApplicationAdapter{
    private GameStateManager gsm;
    private SpriteBatch batch;
    private Music music;

    @Override
    public void create () {
        batch = new SpriteBatch();
        music = Gdx.audio.newMusic(Gdx.files.internal("ThemeMusic.mp3"));
        music.setLooping(true);
        music.setVolume(0.6f);
        music.play();
        gsm = new GameStateManager();
        gsm.push(new MenuState(gsm));
        Gdx.gl.glClearColor(0, 0, 0, 1);
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }

    @Override
    public void dispose () {
        super.dispose();
        batch.dispose();
        music.dispose();
    }
}
