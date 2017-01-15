package com.edimaudo.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture[] birds;
	Texture topTube;
	Texture bottomTube;
	Texture gameOver;
	int flapState = 0; //keeps track of bird state
	float birdY = 0;//birds position vertical
	int score = 0;
	int scoringTube;
	float velocity = 0;
	int gameState = 0;
	float gravity = 2;
	float gap = 400;
	float maxTubeOffset;
	Random random;
	float tubeVelocity = 4;
	int numberOfTubes = 4;
	float[] tubeX = new float[numberOfTubes];
	float[] tubeOffset = new float[numberOfTubes];
	float distanceBetweenTubes;
	Circle birdCircle;
	Rectangle[] topTubeRectangles;
	Rectangle[] bottomTubeRectangles;
	ShapeRenderer shapeRenderer;
	BitmapFont font;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");

		topTube = new Texture("toptube.png");
		bottomTube = new Texture("bottomtube.png");
		gameOver = new Texture("game_over.jpg");
		maxTubeOffset = Gdx.graphics.getHeight()/ 2 - gap / 2 - 100;
		random = new Random();
		distanceBetweenTubes = Gdx.graphics.getWidth() * 3 / 4;
		birdCircle = new Circle();
		topTubeRectangles = new Rectangle[numberOfTubes];
		bottomTubeRectangles = new Rectangle[numberOfTubes];
		//shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(10);//set size
		startGame();


	}

	public void startGame(){
		birdY = Gdx.graphics.getHeight()/2 - birds[0].getHeight()/2;
		for (int i = 0; i < numberOfTubes; i++){
			tubeOffset[i] = (random.nextFloat() - 0.5f)* (Gdx.graphics.getHeight() - gap - 200);
			tubeX[i] = Gdx.graphics.getWidth()/2 - topTube.getWidth()/2 + Gdx.graphics.getWidth() +  i * distanceBetweenTubes;
			topTubeRectangles[i] = new Rectangle();
			bottomTubeRectangles[i] = new Rectangle();
		}
	}
	@Override
	public void render () {
		batch.begin();//start display sprites
		batch.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());//set whole screen

		if (gameState == 1){
			if (tubeX[scoringTube] < Gdx.graphics.getWidth()/2){
				score++;
				Gdx.app.log("Score", String.valueOf(score));
				if(scoringTube < numberOfTubes - 1){
					scoringTube++;
				} else {
					scoringTube = 0;
				}
			}
			if(Gdx.input.justTouched()){
				velocity=-30;

			}
			for (int i = 0; i < numberOfTubes; i++) {

				if (tubeX[i] < - topTube.getWidth()){
					tubeX[i] += numberOfTubes * distanceBetweenTubes;
					tubeOffset[i] = (random.nextFloat() - 0.5f)* (Gdx.graphics.getHeight() - gap - 200);
				} else {
					tubeX[i] = tubeX[i] - tubeVelocity;

				}

				tubeX[i] = tubeX[i] - tubeVelocity;
				batch.draw(topTube, tubeX[i], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i]);
				batch.draw(bottomTube, tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2
								- bottomTube.getHeight() + tubeOffset[i]);
				topTubeRectangles[i] = new Rectangle(tubeX[i],Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i],
				topTube.getWidth(), topTube.getHeight());

				bottomTubeRectangles[i] = new Rectangle(tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2
								- bottomTube.getHeight() + tubeOffset[i], bottomTube.getWidth(), bottomTube.getHeight());
			}


			if (birdY > 0){
				velocity = velocity + gravity;
				birdY -= velocity;
			} else {
				gameState = 2;
			}


		} else if (gameState == 0) {

			//check if screen is touched
			if (Gdx.input.justTouched()){
				//Gdx.app.log("Touched", "Yes");
				gameState = 1;
			}
		} else if (gameState == 2){
			batch.draw(gameOver,Gdx.graphics.getWidth()/2 - gameOver.getWidth()/2,Gdx.graphics.getHeight()/2 - gameOver.getHeight()/2);
			if (Gdx.input.justTouched()){
				//Gdx.app.log("Touched", "Yes");
				gameState = 1;
				startGame();
				score = 0;
				scoringTube = 0;
				velocity = 0;

			}
		}

		if (flapState == 0){
			flapState = 1;
		} else {
			flapState = 0;
		}

		batch.draw(birds[flapState],Gdx.graphics.getWidth()/2 - birds[flapState].getWidth()/2,birdY);//center of screen
		font.draw(batch,String.valueOf(score),100,200);//draw to screen

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
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
