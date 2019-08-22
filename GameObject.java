package com.tutorial.main;

import java.awt.Graphics;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected int valX, valY;
	
	public GameObject(int x,int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render( Graphics g);
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public ID getId() {
		return id;
	}
	
	public void setValX(int x) {
		this.valX = x;
	}
	
	public void setValY(int y) {
		this.valY = y;
	}
	
	public int getValX() {
		return valX;
	}
	
	public int getValY() {
		return valY;
	}
	
}
