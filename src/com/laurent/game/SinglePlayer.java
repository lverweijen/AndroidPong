package com.laurent.game;

import com.laurent.framework.Game;
import com.laurent.framework.Input.TouchEvent;

public class SinglePlayer extends Pong {

	public SinglePlayer(Game game) {
		super(game);
	}
	
	@Override
	void createPaddles() {
		double yStart = game.getGraphics().getHeight() / 2 - Assets.paddle.getHeight() / 2;
		double x2 = game.getGraphics().getWidth() - Assets.paddle.getWidth();
		
		paddles[0] = new Paddle(0, yStart, 10);
		paddles[1] = new Paddle(x2, yStart, 2);
	}
	
	@Override
	public void handleInput() {
		
		// Paddle 0 is controlled by user input
		for(TouchEvent event: game.getInput().getTouchEvents()) {
			switch(event.type){
			case TouchEvent.TOUCH_DRAGGED: 
			case TouchEvent.TOUCH_DOWN:
				paddles[0].follow(event.y);
				break;
			}
        }
		
		// The other just follows the ball
		paddles[1].follow(ball.getCenterY());
	}

}
