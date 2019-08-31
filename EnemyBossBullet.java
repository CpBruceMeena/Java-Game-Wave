package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{
 
	private Handler handler;
	Random r = new Random();
	
	public EnemyBossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		valX = (r.nextInt(5 - -5) + -5);
		valY = 5.0f;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += valX; 
		y += valY;
		 
	 	//if(y <= 0 || y>=Game.HEIGHT - 60) valY *= -1;
	 	//if(x <= 0 || x>=Game.WIDTH - 32) valX *= -1;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}  
	
	public void render( Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
}
