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
		
	}
	
	public void tick() {
		x += valX;
		y += valY;
		x = Game.clamp(x,  0, Game.WIDTH - 50);
		y = Game.clamp(y,  0, Game.HEIGHT - 66);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	
	
} 
