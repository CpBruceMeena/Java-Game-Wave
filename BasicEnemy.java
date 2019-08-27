package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
 
	private Handler handler;
	
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;  
		valX = 5.0f;
		valY = 5.0f;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += valX; 
		y += valY;
		 
	  	if(y <= 0 || y>=Game.HEIGHT - 60) valY *= -1;
		if(x <= 0 || x>=Game.WIDTH - 32) valX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}  
	
	public void render( Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
			
		g.setColor(Color.green);
		g2d.draw(getBounds());
		
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
}
