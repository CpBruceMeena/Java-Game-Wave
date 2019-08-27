package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//valX and valY represents the velocity, its just typo
// its actually vel for velocity

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		 
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 32, 32);
	}
	
	public void tick() {
		x += valX;
		y += valY;
		x = Game.clamp((int)x,  0, Game.WIDTH - 50);
		y = Game.clamp((int)y,  0, Game.HEIGHT - 66);
	
		// below we are creating a trail for the player.
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 32, 32, 0.05f, handler));
		
		collision();
	} 
	
	public void collision() {
			for(int i = 0; i<handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i); 
				
				if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
					// tempObject is like a basic enemy
					//Collision
					if(getBounds().intersects(tempObject.getBounds())){
						HUD.HEALTH -= 2; 
					}
				}
			}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x,(int) y, 32, 32);
	}
	
} 
