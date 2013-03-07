package com.laurent.game;

import java.util.List;

import com.laurent.framework.Image;
import com.laurent.framework.Game;
import com.laurent.framework.Graphics;
import com.laurent.framework.Graphics.ImageFormat;
import com.laurent.framework.Input.TouchEvent;
import com.laurent.framework.Screen;
import com.laurent.framework.implementation.AndroidGraphics;

public class MainMenuScreen extends Screen {

	public MainMenuScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
	    //Graphics g = game.getGraphics();
        //List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        
        for(TouchEvent event: game.getInput().getTouchEvents()) {
        	if (event.type == TouchEvent.TOUCH_UP) { // && inBounds(event, 0, 0, 250, 250)) {
                //game.setScreen(new GameScreen(game));
        		
        		// Single player or multiplayer
        		if(event.y < game.getGraphics().getHeight() / 2)
        			game.setScreen(new SinglePlayer(game));
        		else
        			game.setScreen(new MultiPlayer(game));
            }        	
        }
        
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);
	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
	            int height) {
	      if (event.x > x && event.x < x + width - 1 && event.y > y
	                && event.y < y + height - 1)
	            return true;
	        else
	            return false;
	}

	@Override
	public void paint(float deltaTime) {
		AndroidGraphics g = (AndroidGraphics)game.getGraphics();
		Image menu = Assets.menu;
        //g.drawImage(Assets.menu, 0, 0);
		g.drawScaledImage(menu, 0, 0, g.getWidth(), g.getHeight(), 0, 0, menu.getWidth(), menu.getHeight());
	}

	@Override
	public void pause() {
        /*Graphics g = game.getGraphics();
        g.drawImage(Assets.menu, 0, 0);*/
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void backButton() {
		android.os.Process.killProcess(android.os.Process.myPid());	
	}

}
