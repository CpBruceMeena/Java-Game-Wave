package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject{
 
	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		
		valX =5;
		valY = 5;
	}
	
	public void tick() {
		x += valX; 
		y += valY;
		
		if(y <= 0 || y>=Game.HEIGHT - 60) valY *= -1;
		if(x <= 0 || x>=Game.WIDTH - 32) valX *= -1;
	}
	
	public void render( Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
}
