 package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Random r = new Random();
	private HUD hud;   
	private Game game;
	private Handler  handler;
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
 		if(game.gamestate == STATE.Menu) {	
			//play button
			if(mouseOver(mx, my,175, 150, 250, 64)) {
	//			game.gamestate = STATE.Game;
	//			handler.addObject(new Player(Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player, handler));	
	//			handler.clearEnemys();
	//		  	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.EnemyBoss, handler));
				game.gamestate = STATE.Select;
				return;
			}
					
			//Help button
			if(mouseOver(mx, my, 175, 250, 250, 64 )) {
				game.gamestate = STATE.Help;
			}
			
			//quit button
			if(mouseOver(mx, my,175, 350, 250, 64 )) { 
				System.exit(1);
			}
		}
		
		if(game.gamestate == STATE.Select) {	
			//Normal button
 			if(mouseOver(mx, my,175, 150, 250, 64)) {
				game.gamestate = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player, handler));	
				handler.clearEnemys();
			  	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			  	game.diff = 0;
			}
					
			//Hard button
			if(mouseOver(mx, my, 175, 250, 250, 64 )) {
				game.gamestate = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player, handler));	
				handler.clearEnemys();
			  	handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));			  	
			  	game.diff = 1;
			}
			
			//back button
			if(mouseOver(mx, my,175, 350, 250, 64 )) {
				game.gamestate = STATE.Menu;	
				return;	
			}
		}
		
		//back Button for help 
		if(game.gamestate ==  STATE.Help) {
			if(mouseOver(mx, my, 175, 350, 250, 64)) {
			game.gamestate = STATE.Menu;	
				return;	
			}
		}
		
		// to restart the game
		if(game.gamestate ==  STATE.End) {
			if(mouseOver(mx, my, 175, 350, 250, 64)) {
				game.gamestate = STATE.Menu;	
				hud.setLevel(1);
				hud.setscore(0);
			}
		}	
		
	}
	 
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			 if(my > y && my < y + height) {
				 return true;
			 }   
			 else return false;
		}
		else return false;
	}
		
	public void tick() {
	
	}

 	public void render(Graphics g) {
 		
 		if(game.gamestate == STATE.Menu) {
 		
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);

		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("WAVE", 240, 100);
		
		g.setFont(fnt2);
		g.drawRect(175, 150, 250, 64);
		g.drawString("Play", 250, 200);		
		

		g.drawRect(175, 250, 250, 64);	
		g.drawString("Help", 250, 300);		 
		
		g.drawRect(175, 350, 250, 64);	
		g.drawString("Quit", 250, 400);		
 		}
 		else if(game.gamestate == STATE.Help) {
 			Font fnt = new Font("arial", 1, 50);
 			Font fnt2 = new Font("arial", 1, 30);
 			Font fnt3 = new Font("arial", 1, 20);
   
 			g.setFont(fnt);
 			g.setColor(Color.white);
 			g.drawString("Help", 240, 50);
 			
 			g.setFont(fnt3);
 			g.drawString("Use up, down, left, right to move in the screen. ",  50, 200);
 			
 			g.setFont(fnt2);
 			g.drawRect(175, 350, 250, 64);	
 			g.drawString("Back", 250, 400);		
 	 		
 			
 		}
 		else if(game.gamestate == STATE.End) {
 			Font fnt = new Font("arial", 1, 50);
 			Font fnt2 = new Font("arial", 1, 30);
 			Font fnt3 = new Font("arial", 1, 20);

 			g.setFont(fnt);
 			g.setColor(Color.white);
 	  		g.drawString("Game Over", 200, 70);
 			
 			g.setFont(fnt3);
 			g.drawString("Your score is "  + hud.getscore(),  180, 200);
 			
 			g.setFont(fnt2);
 			g.drawRect(175, 350, 250, 64);	
 			g.drawString("Try Again", 250, 400);					
 		}
 		else if(game.gamestate == STATE.Select) {
 	 		
 			Font fnt = new Font("arial", 1, 50);
 			Font fnt2 = new Font("arial", 1, 30);

 			
 			g.setFont(fnt);
 			g.setColor(Color.white);
 			g.drawString("Select Difficulty", 140, 100);
 			 
 			g.setFont(fnt2);
 			g.drawRect(175, 150, 250, 64);
 			g.drawString("Normal", 250, 200);		
 			

 			g.drawRect(175, 250, 250, 64);	
 			g.drawString("Hard", 250, 300);		
 			
 			g.drawRect(175, 350, 250, 64);	
 			g.drawString("Back", 250, 400);		
 	 		}
 	}
	  
}
