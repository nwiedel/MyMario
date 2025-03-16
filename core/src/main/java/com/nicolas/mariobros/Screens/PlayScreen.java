package com.nicolas.mariobros.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nicolas.mariobros.MarioBros;

public class PlayScreen implements Screen {

    private MarioBros game;

    private OrthographicCamera gameCam;
    private Viewport gameViewport;

    private Hud hud;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public PlayScreen(MarioBros game){
        this.game = game;

        gameCam = new OrthographicCamera();
        gameViewport = new FitViewport(MarioBros.V_WIDTH,
            MarioBros.V_HEIGHT, gameCam);
        hud = new Hud(game.batch);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        gameCam.position.set(gameViewport.getWorldWidth()/2,
            gameViewport.getWorldHeight() / 2, 0);
    }

    @Override
    public void show() {

    }

    private void handleInput(float delta){
        if(Gdx.input.isTouched()){
            gameCam.position.x += 100 * delta;
        }
    }

    private void update(float delta){
        handleInput(delta);

        gameCam.update();
        renderer.setView(gameCam);
    }

    @Override
    public void render(float delta) {
        update(delta);

        ScreenUtils.clear(0.39f, 0.58f, 0.93f, 0f);

        renderer.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gameViewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
