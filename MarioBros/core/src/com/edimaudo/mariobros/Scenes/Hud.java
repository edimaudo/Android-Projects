package com.edimaudo.mariobros.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.edimaudo.mariobros.MarioBros;

/**
 * Created by edima on 2016-10-18.
 */

public class Hud {
  public Stage stage;
  private FitViewport viewPort;
  private Integer worldTimer;
  private Float timeCount;
  private Integer score;

  Label countdownLabel;
  Label scoreLabel;
  Label timeLabel;
  Label levelLabel;
  Label marioLabel;
  Label worldLabel;

  public Hud(SpriteBatch sb){
    worldTimer = 300;
    timeCount = 0f;
    score = 0;
    viewPort = new FitViewport(MarioBros.V_WIDTH,
            MarioBros.V_HEIGHT,
            new OrthographicCamera());
    stage = new Stage(viewPort,sb);
    Table table = new Table();
    table.top();
    table.setFillParent(true);

    countdownLabel = new Label(String.format("%03d",worldTimer),
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    scoreLabel = new Label(String.format("%06d",score),
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    timeLabel = new Label("TIME",
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    levelLabel  = new Label("1-1",
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    worldLabel = new Label("WORLD",
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    marioLabel = new Label("MARIO",
            new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    table.add(marioLabel).expandX().padTop(10);
    table.add(worldLabel).expandX().padTop(10);
    table.add(timeLabel).expandX().padTop(10);

    table.row();
    table.add(scoreLabel).expandX();
    table.add(levelLabel).expandX();
    table.add(countdownLabel).expandX();

    stage.addActor(table);
  }

}
