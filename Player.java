package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

//valX and valY represents the velocity, its just typo
// its actually vel for velocity

public class Player extends GameObject{

	Random r = new Random();
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	//	valX = r.nextInt(5) + 1;
	//	valY = r.nextInt(5);
	}
	
	public void tick() {
		x += valX;
		y += valY;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
}
