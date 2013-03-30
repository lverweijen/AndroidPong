package com.laurent.game;

import com.laurent.sprite.Rect;

public class Paddle extends Rect {
	private double followY;
	private double speed = 10;
	
	public Paddle(double x, double y, double speed) {
		super(Assets.paddle, x, y);
		this.speed = speed;
		followY = getCenterY();
	}
	
	public void update(double deltaTime) {		
		double step = deltaTime * speed;
		double diff = followY - getCenterY();
		double move = Math.min(step, Math.abs(diff)) * Math.signum(diff);
		move(0, move);
	}
	
	/**
	 * Makes the paddle follow a position
	 * @param followY
	 */
	public void follow(double y) {
		followY = y;
	}

}
