package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{
 
	private Handler handler;
	
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;  
		valX = 8;
		valY = 9;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += valX; 
		y += valY;
		 
	  	if(y <= 0 || y>=Game.HEIGHT - 60) valY *= -1;
		if(x <= 0 || x>=Game.WIDTH - 32) valX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.cyan, 16, 16, 0.02f, handler));
	}   
	
	public void render( Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, 16, 16);
 	}
}
