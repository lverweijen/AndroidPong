package com.laurent.game;

import com.laurent.framework.Image;

public class Rect {
	public Image image;
	protected double x, y;
	
	public Rect(Image image, double x, double y) {
		this.image = image;
		this.x = x; this.y = y;
	}
	
	public boolean collide(Rect other) {
		return (this.getLeft() <= other.getRight() &&
				other.getLeft()<= this.getRight() &&
				this.getTop() <= other.getBottom() &&
				other.getTop() <= this.getBottom());
	}

	public double getTop() {
		return y;
	}
	public double getBottom() {
		return y + image.getHeight();
	}
	
	public double getCenterY() {
		return y + image.getHeight() / 2;
	}
	
	public double getHeight() {
		return image.getHeight();
	}
	
	public double getLeft() {
		return x;
	}
	
	public double getRight() {
		return x + image.getWidth();
	}
	
	public double getCenterX() {
		return x + image.getWidth() / 2;
	}
	
	public double getWidth() {
		return image.getWidth();
	}
}
