package com.laurent.game;

import com.laurent.framework.Game;
import com.laurent.framework.Image;

import android.R.anim;

public class Ball extends Rect {
	public double dx, dy;
	private Game game;
	private double speed = 1.5;
	
	public Ball(Game game) {
		super(Assets.ball, 0, 0);
		dx = 1; dy = 1;
		this.game = game;
	}
	
	public void update(double timeFloat) {
		x += speed * timeFloat * dx;
		y += speed * timeFloat * dy;

		int width = game.getGraphics().getWidth();
		int height = game.getGraphics().getHeight();
		
		// Bounce vertically		
		if (getBottom() > height - 25)
			dy = -Math.abs(dy);
		if (getTop() < 25)
			dy = Math.abs(dy);
	}
	
	public void bounceHorizontally() {
		if(game.getGraphics().getWidth() / 2 < getCenterX())
			dx = -Math.abs(dx);
		else
			dx = Math.abs(dx);
	}

	public void respawn(double xPos) {
		x = xPos;
		dx = -dx;
	}

	public void increaseSpeed() {
		speed += 0.1;		
	}

	public void decreaseSpeed() {
		speed = Math.max(speed - 1, 1);
	}
}
