package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
 
	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;  
		
		for(int i = 0; i<handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}

		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += valX; 
		y += valY;
		
		float diffX = x - player.getX() - 16;
		float diffY = y - player.getY() - 16;
		float distance = (float)Math.sqrt((x - player.getX())*(x - player.getX()) + (y - player.getY())*(y - player.getY()));
		
		valX = (float)((-1.0/distance)*diffX); 
		valY = (float)((-1.0/distance)*diffY);
		
		
	  	//if(y <= 0 || y>=Game.HEIGHT - 60) valY *= -1;
		//if(x <= 0 || x>=Game.WIDTH - 32) valX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.green, 16, 16, 0.02f, handler));
	}  
	
	public void render( Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x,(int) y, 16, 16);
	}
}
