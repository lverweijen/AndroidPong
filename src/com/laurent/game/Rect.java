package com.laurent.game;

import java.util.Locale;

import com.laurent.framework.Image;

public class Rect {
	protected double left, top;
	protected double width, height;
	
	public Rect(double x, double y, double w, double h) {
		setLeft(x); 
		setTop(y);
		width = w;
		height = h;
	}
	
	public Rect(Rect r) {
		this(r.getLeft(), r.getTop(), r.getWidth(), r.getHeight());
	}
	
	public Rect(Image image, double x, double y) {
		this(x, y, image.getWidth(), image.getHeight());
	}
	
	public boolean collides(Rect other) {
		return (this.getLeft() < other.getRight() &&
				other.getLeft()< this.getRight() &&
				this.getTop() < other.getBottom() &&
				other.getTop() < this.getBottom());
	}
	
	public boolean collides(int x, double y, double width, double height) {
		return collides(new Rect(x, y, width, height));
	}
	
	public void move(double dx, double dy) {
		left += dx;
		top += dy;
	}
	
	public Rect moved(double dx, double dy) {
		Rect newRect = new Rect(this);
		newRect.move(dx, dy);
		return newRect;
	}

	public double getTop() {
		return top;
	}
	
	public void setTop(double top) {
		this.top = top;
	}
	
	public double getBottom() {
		return top + getHeight();
	}
	
	public void setBottom(double y) {
		top = y - getHeight();
	}
	
	public double getCenterY() {
		return top + getHeight() / 2;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getLeft() {
		return left;
	}
	
	public void setLeft(double left) {
		this.left = left;
	}
	
	public double getRight() {
		return left + getWidth();
	}
	
	public void setRight(double x) {
		left = x - getWidth();
	}
	
	public double getCenterX() {
		return left + getWidth() / 2;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return String.format(Locale.ENGLISH, "(%f,  %f, %f, %f)", left, top, width, height);
	}
}
