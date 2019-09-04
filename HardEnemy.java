package com.tutorial.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class HardEnemy extends GameObject{
 
	private Handler handler;
	
	private Random r  =new Random();
	
	public HardEnemy(int x, int y, ID id, Handler handler) {
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
		 
	  	if(y <= 0 || y>=Game.HEIGHT - 60) {
	  		if(valY < 0) valY = -(r.nextInt(7) + 1)*(-1);
	  		else valY = (r.nextInt(7) + 1)*(-1);
	  	}
		if(x <= 0 || x>=Game.WIDTH - 32) {
	  		if(valX < 0) valY = -(r.nextInt(7) + 1)*(-1);
	  		else valX = (r.nextInt(7) + 1)*(-1);
	  	}
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.yellow, 16, 16, 0.02f, handler));
	}  
	
	public void render( Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 16, 16);
	}
}
