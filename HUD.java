package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	
	public void tick() {
		HEALTH--;
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(35, 35, 200,  32);
		

		g.setColor(Color.green);
		g.fillRect(35, 35, HEALTH*2,  32);

		g.setColor(Color.white);
		g.drawRect(35, 35, 200,  32);
	}
}
