// unused
package com.laurent.game;

import com.laurent.framework.Game;
import com.laurent.framework.Graphics;
import com.laurent.framework.Screen;
import com.laurent.framework.Graphics.ImageFormat;

public class GameScreen extends Screen {

	public GameScreen(Game game) {
		// TODO Auto-generated constructor stub
		super(game);
		System.out.println("hoi van laurent");
		Graphics g = game.getGraphics();
        Assets.menu = g.newImage("character.png", ImageFormat.ARGB4444);
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub

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
