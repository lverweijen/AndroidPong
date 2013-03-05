package com.laurent.game;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.DisplayMetrics;

import com.laurent.framework.Game;
import com.laurent.framework.Graphics;
import com.laurent.framework.Image;
import com.laurent.framework.Screen;
import com.laurent.framework.Graphics.ImageFormat;
import com.laurent.framework.Input.TouchEvent;
import com.laurent.framework.implementation.AndroidGraphics;

public class Pong extends Screen{
	Ball ball;
	Paddle[] paddles = new Paddle[2];
	int[] scores = new int[2];
	
	double score1, score2;
	
	Paint scorePaint;//

	public Pong(Game game) {
		super(game);
		System.out.println("Pong started");
		
		double yStart = game.getGraphics().getHeight() / 2 - Assets.paddle.getHeight() / 2;
		double x2 = game.getGraphics().getWidth() - Assets.paddle.getWidth();
		
		ball = new Ball(game);
		paddles[0] = new Paddle(0, yStart, 10);
		paddles[1] = new Paddle(x2, yStart, 2);
		
		scorePaint = new Paint();
		scorePaint.setTextSize(30);
		scorePaint.setTextAlign(Align.CENTER);
		scorePaint.setAntiAlias(true);
		scorePaint.setColor(Color.WHITE);
	}

	@Override
	public void update(float deltaTime) {
		
		for(TouchEvent event: game.getInput().getTouchEvents()) {
			switch(event.type){
			case TouchEvent.TOUCH_DRAGGED:
			case TouchEvent.TOUCH_DOWN:
				paddles[0].follow(event.y);
				break;
			case TouchEvent.TOUCH_UP:
				paddles[0].stop();
				break;
			}
        }
		
		paddles[1].follow(ball.getCenterY());
		ball.update(deltaTime);
		
		for(Paddle paddle: paddles) {
			paddle.update(deltaTime);
			
			if(paddle.collide(ball)) {
				ball.bounceHorizontally();
				ball.increaseSpeed();
			}
		}
		
		boolean ballLeft = false;
		
		if(ball.getRight() > game.getGraphics().getWidth()) {
			scores[0]++;
			ballLeft = true;
		}
		
		if(ball.getLeft() < 0) {
			scores[1]++;
			ballLeft = true;
		}
		
		if(ballLeft) {
			ball.respawn((game.getGraphics().getWidth() - ball.getWidth()) / 2);
			//ball.decreaseSpeed();
		}
	}

	@Override
	public void paint(float deltaTime) {
		AndroidGraphics g = (AndroidGraphics) game.getGraphics();		
		g.clearScreen(Color.WHITE);
		
		Image bg = Assets.background;
		
		// Dit werkt mooi, als er geen breedte bestaat
		//int height = g.getHeight();
		//int width = bg.getWidth() * g.getHeight() / bg.getHeight();
		//g.drawScaledImage(bg, 0, 0, width, height, 0, 0, bg.getWidth(), bg.getHeight());
		
		// Anders doen we
		int height = g.getHeight();
		int width = g.getWidth();
		g.drawScaledImage(bg, 0, 0, width, height, 0, 0, bg.getWidth(), bg.getHeight());
		
		g.drawImage(Assets.ball, (int)ball.getLeft(), (int)ball.getTop());
		g.drawImage(Assets.paddle, (int)paddles[0].getLeft(), (int)paddles[0].getTop());
		g.drawImage(Assets.paddle, (int)paddles[1].getLeft(), (int)paddles[1].getTop());
		
		g.drawString("" + scores[0], 20, 50, scorePaint);
		g.drawString("" + scores[1], width - 20, 60, scorePaint);
	}

	private Object getWindowManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void backButton() {
		android.os.Process.killProcess(android.os.Process.myPid());	
	}

}
