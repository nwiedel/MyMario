package com.nicolas.mariobros;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nicolas.mariobros.Screens.PlayScreen;

public class MarioBros extends Game {

    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 208;
    public static final float PPM = 100f;

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new PlayScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
