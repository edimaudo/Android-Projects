package com.edimaudo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class BalloonTap extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background, balloon, platform;
	boolean gameEnd = false;
	float balloonY;
	int score;
	int gameState;
	BitmapFont font;
	ShapeRenderer shapeRenderer;
	Circle balloonCircle;
	Rectangle platformRectangle;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.png");
		balloon = new Texture("balloon@2x.png");
		platform = new Texture("platform.png");
		balloonY = Gdx.graphics.getHeight()/2 - balloon.getHeight()/2;
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.getData().setScale(10);
		balloonCircle = new Circle();
		platformRectangle = new Rectangle();
	}

	@Override
	public void render () {

		if(Gdx.input.justTouched()){
			Gdx.app.log("Touched","Yes");
		}

		batch.begin();
		batch.draw(background,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(balloon,Gdx.graphics.getWidth()/2 - balloon.getWidth()/2,balloonY);
		batch.draw(platform,Gdx.graphics.getWidth()/2 - platform.getWidth()/2,100);
		font.draw(batch,String.valueOf(score),Gdx.graphics.getWidth()/2 - 50,Gdx.graphics.getHeight()-100);

		/*
				birdCircle.set(Gdx.graphics.getWidth()/2,birdY + birds[flapState].getHeight()/2,
						birds[flapState].getWidth()/2);


		//creates shape of object
		//shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		//shapeRenderer.setColor(Color.BLUE);

		//shapeRenderer.circle(birdCircle.x,birdCircle.y,birdCircle.radius);

		for (int i = 0; i < numberOfTubes; i++){
			//shapeRenderer.rect(tubeX[i],Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i],
			//				topTube.getWidth(), topTube.getHeight());
			//shapeRenderer.rect(tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2
			//				- bottomTube.getHeight() + tubeOffset[i], bottomTube.getWidth(), bottomTube.getHeight());

			//collision d etection
			if (Intersector.overlaps(birdCircle,topTubeRectangles[i]) || Intersector.overlaps(birdCircle,bottomTubeRectangles[i])){
				//Gdx.app.log("Collision","Yes");
				gameState = 2;
			}
		}


		//shapeRenderer.end();

		 */

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
