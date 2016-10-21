package com.edimaudo.mariobros.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.edimaudo.mariobros.MarioBros;
import com.edimaudo.mariobros.Scenes.Hud;

/**
 * Created by edima on 2016-10-18.
 */

public class PlayScreen implements Screen {
  private OrthographicCamera gameCam;
  private MarioBros game;
  //Texture texture;
  private Viewport gamePort;
  private Hud hud;

  public PlayScreen(MarioBros game){
    this.game = game;
    //texture = new Texture("badlogic.jpg");
    gameCam = new OrthographicCamera();
    gamePort = new FitViewport(MarioBros.V_WIDTH,MarioBros.V_WIDTH,gameCam);
    hud = new Hud(game.batch);
  }

  @Override
  public void show() {

  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(1,0,0,1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
    hud.stage.draw();
    //game.batch.setProjectionMatrix(gameCam.combined);
    //game.batch.begin();
    //game.batch.draw(texture,0,0);
    //game.batch.end();

  }

  @Override
  public void resize(int width, int height) {
    gamePort.update(width,height);
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
