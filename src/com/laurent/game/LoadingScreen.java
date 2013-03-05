package com.laurent.game;

import com.laurent.framework.Game;
import com.laurent.framework.Graphics;
import com.laurent.framework.Graphics.ImageFormat;
import com.laurent.framework.Screen;

public class LoadingScreen extends Screen {

	public LoadingScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        //Assets.menu = g.newImage("menu.jpg", ImageFormat.RGB565);
        Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);
        //Assets.click = game.getAudio().createSound("explode.ogg");
       
        // Pong
        Assets.ball = g.newImage("ball.png", ImageFormat.ARGB4444);
        Assets.paddle = g.newImage("paddle.png", ImageFormat.ARGB4444);
        //Assets.background = g.newImage("background.png", ImageFormat.ARGB4444);
        Assets.background = g.newImage("pong-bg.jpg", ImageFormat.ARGB4444);
        
        game.setScreen(new MainMenuScreen(game));
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
