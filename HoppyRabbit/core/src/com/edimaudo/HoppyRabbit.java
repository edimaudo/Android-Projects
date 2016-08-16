package com.edimaudo;

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


public class HoppyRabbit extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background, topCarrot, bottomCarrot,bgcrystal,
					playButton, gameOver, clouds, ground, rabbit[];
	int score = 0;
	int hopState = 0;
	float rabbitY = 0;
	int scoringCarrot;
	float velocity = 0;
	int gameState = 0;
	float gravity = 2;
	float gap = 400;
	float maxCarrotOffset;
	Random random;
	float carrotVelocity = 4;
	int numberOfCarrots = 4;
	float[] carrotX = new float[numberOfCarrots];
	float[] carrotOffset = new float[numberOfCarrots];
	float distanceBetweenCarrots;
	Circle rabbitCircle;
	Rectangle[] topCarrotRectangles;
	Rectangle[] bottomCarrotRectangles;
	ShapeRenderer shapeRenderer;
	BitmapFont font;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.png");
		rabbit = new Texture[2];
		rabbit[0] = new Texture("bunny1.png");
		rabbit[1] = new Texture("bunny2.png");
		topCarrot = new Texture("carrot_top.png");
		bottomCarrot = new Texture("carrot_bottom.png");
		gameOver = new Texture("restart_button.png");
		playButton = new Texture("play_button.png");
		clouds = new Texture("clouds.png");
		ground = new Texture("ground.png");
		bgcrystal = new Texture("bg_crystals.png");
		maxCarrotOffset = Gdx.graphics.getHeight()/2 - gap /2 - 100;
		random = new Random();
		distanceBetweenCarrots = Gdx.graphics.getWidth() * 3 / 4;
		rabbitCircle = new Circle();
		topCarrotRectangles = new Rectangle[numberOfCarrots];
		bottomCarrotRectangles = new Rectangle[numberOfCarrots];
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.getData().setScale(10);
		startGame();



	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		//batch.draw(ground,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/16);

		switch (gameState){
			case 0:
				//game begin
				batch.draw(playButton,Gdx.graphics.getWidth()/2 - playButton.getWidth()/2,Gdx.graphics.getHeight()/2 - playButton.getHeight()/2);
				if (Gdx.input.justTouched()){
					gameState = 1;
				}
				break;
			case 1:
				//in game
				if (carrotX[scoringCarrot] < Gdx.graphics.getWidth()/2){
					score++;
					if (scoringCarrot < numberOfCarrots - 1){
						scoringCarrot++;
					} else {
						scoringCarrot = 0;
					}
				}

				if (Gdx.input.justTouched()){
					velocity=-30;
				}
				for (int i = 0; i < numberOfCarrots; i++){
					if(carrotX[i] < - topCarrot.getWidth()){
						carrotX[i] += numberOfCarrots * distanceBetweenCarrots;
						carrotOffset[i] = (random.nextFloat() - 0.5f)* (Gdx.graphics.getHeight() - gap - 200);
					} else {
						carrotX[i] = carrotX[i] - carrotVelocity;
					}
					carrotX[i] = carrotX[i] - carrotVelocity;
					batch.draw(topCarrot, carrotX[i], Gdx.graphics.getHeight() / 2 + gap / 2 + carrotOffset[i]);
					batch.draw(bottomCarrot, carrotX[i], Gdx.graphics.getHeight() / 2 - gap / 2
									- bottomCarrot.getHeight() + carrotOffset[i]);
					topCarrotRectangles[i] = new Rectangle(carrotX[i],Gdx.graphics.getHeight() / 2 + gap / 2 + carrotOffset[i],
									topCarrot.getWidth(), topCarrot.getHeight());
					bottomCarrotRectangles[i] = new Rectangle(carrotX[i], Gdx.graphics.getHeight() / 2 - gap / 2
									- bottomCarrot.getHeight() + carrotOffset[i], bottomCarrot.getWidth(), bottomCarrot.getHeight());

				}
				if (rabbitY > 0){
					velocity = velocity + gravity;
					rabbitY -= velocity;
				} else {
					gameState = 2;
				}

				break;
			case 2:
				//game over
				batch.draw(gameOver,Gdx.graphics.getWidth()/2 -
								gameOver.getWidth()/2,Gdx.graphics.getHeight()/2 - gameOver.getHeight()/2);
				if (Gdx.input.justTouched()){
					gameState = 1;
					score = 0;
					scoringCarrot = 0;
					velocity = 0;
					startGame();
				}
				break;

		}

		if (hopState == 0){
			hopState = 1;
		} else {
			hopState = 0;
		}

		batch.draw(rabbit[hopState],Gdx.graphics.getWidth()/2 - rabbit[hopState].getWidth()/2,rabbitY);
		font.draw(batch,String.valueOf(score),100,200);
		rabbitCircle.set(Gdx.graphics.getWidth()/2,rabbitY + rabbit[hopState].getHeight()/2,
						rabbit[hopState].getWidth()/2);


		for (int i = 0; i < numberOfCarrots; i++){
			if (Intersector.overlaps(rabbitCircle,topCarrotRectangles[i]) ||
							Intersector.overlaps(rabbitCircle,bottomCarrotRectangles[i])){
				//Gdx.app.log("Collision","Yes");
				gameState = 2;
			}
		}
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void startGame(){
		rabbitY = Gdx.graphics.getHeight()/2 - rabbit[0].getHeight()/2;
		for (int i = 0; i < numberOfCarrots; i++){
			carrotOffset[i] = (random.nextFloat() - 0.5f)* (Gdx.graphics.getHeight() - gap - 200);
			carrotX[i] = Gdx.graphics.getWidth()/2 - topCarrot.getWidth()/2 + Gdx.graphics.getWidth() +  i * distanceBetweenCarrots;
			topCarrotRectangles[i] = new Rectangle();
			bottomCarrotRectangles[i] = new Rectangle();
		}
	}
}
