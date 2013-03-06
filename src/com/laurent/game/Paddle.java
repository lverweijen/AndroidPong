package com.laurent.game;

import com.laurent.framework.Image;
import com.laurent.framework.Input.TouchEvent;

public class Paddle extends Rect {
	private double dy;
	private double speed = 10;
	
	public Paddle(double x, double y, double speed) {
		super(Assets.paddle, x, y);
		this.speed = speed;
	}
	
	public void update(double deltaTime) {
		this.y += this.dy * deltaTime;
	}
	
	/**
	 * Stops the paddle from moving
	 */
	public void stop() {
		this.dy = 0;
	}
	
	/**
	 * Makes the paddle follow a position
	 * @param followY
	 */
	public void follow(double followY) {
		if (Math.abs(followY - getCenterY()) < speed)
		{
			y = followY - image.getHeight() / 2;
			dy = 0;
		}
		else if(followY > getCenterY())
			dy = speed;
		else
			dy = -speed;
	}

}
