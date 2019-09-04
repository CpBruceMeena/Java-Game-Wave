package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{
 
	private Handler handler;
	
	Random r = new Random();
	
	private int timer = 50;
	private int timer2 = 50;
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;  
	
		valX = 0;
		valY = 5.0f;
	}
	
	public Rectangle getBounds() {  
		return new Rectangle((int)x, (int)y, 96, 96);
	}
	
	public void tick() {
		x += valX; 
		y += valY;
		 
		
		timer--;
		if(timer <= 0) {
			valY = 0;
		}
		else timer--;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0) {
			if(valX == 0) valX = 3.0f;
			if(valX > 0)
				valX += 0.005f;
			else if(valX < 0) valX -= 0.005;
			
			
			valX = Game.clamp((int)valX, -10, 10);
			
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x + 48, (int)y + 48, ID.BasicEnemy, handler));
		}
//	  	if(y <= 0 || y>=Game.HEIGHT - 60) valY *= -1;
		if(x <= 0 || x>=Game.WIDTH - 96) valX *= -1;
		
//		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 96, 96, 0.008f, handler));
	}  
	
	public void render( Graphics g) {	
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 96, 96);
	}
}
