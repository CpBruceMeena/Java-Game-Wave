package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{
 
	private Handler handler;
	
	Random r = new Random();

	private Color col;
	
	int dir = 0;
	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		dir = r.nextInt(2);
		
		if(dir == 0) {
			valX = 2;
			valY = 9;
		}
		else if(dir == 1) {
			valX = 9;
			valY = 2;
		}
	
		col = new Color(r.nextInt(200), r.nextInt(200), r.nextInt(200));
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += valX; 
		y += valY;
		 
	  	if(y <= 0 || y>=Game.HEIGHT - 60) valY *= -1;
		if(x <= 0 || x>=Game.WIDTH - 32) valX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, col, 16, 16, 0.05f, handler));
	}   
	
	public void render( Graphics g) {
		g.setColor(col);
		g.fillRect((int)x, (int)y, 16, 16);
 	}
}
