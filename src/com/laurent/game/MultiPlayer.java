package com.laurent.game;

import com.laurent.framework.Game;
import com.laurent.framework.Input.TouchEvent;

public class MultiPlayer extends Pong {
	
	public MultiPlayer(Game game) {
		super(game);
	}
	
	@Override
	void createPaddles() {
		double yStart = game.getGraphics().getHeight() / 2 - Assets.paddle.getHeight() / 2;
		double x2 = game.getGraphics().getWidth() - Assets.paddle.getWidth();
		
		paddles[0] = new Paddle(0, yStart, 10);
		paddles[1] = new Paddle(x2, yStart, 10);
	}
	
	@Override
	public void handleInput() {
		
		// Respond to user input
		for(TouchEvent event: game.getInput().getTouchEvents()) {
			// Control the paddle that is closest
			int paddleIndex = event.x < game.getGraphics().getWidth() / 2 ? 0 : 1;
			
			switch(event.type){
			case TouchEvent.TOUCH_DRAGGED:
			case TouchEvent.TOUCH_DOWN:
				paddles[paddleIndex].follow(event.y);
				break;
			}
		}
	}

}
