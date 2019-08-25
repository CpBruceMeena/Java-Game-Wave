package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	public Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player) {
				// key events for player 1
				
				if(key == KeyEvent.VK_UP)  tempObject.setValY(-5);
				if(key == KeyEvent.VK_DOWN)  tempObject.setValY(5);
				if(key == KeyEvent.VK_LEFT)  tempObject.setValX(-5);
				if(key == KeyEvent.VK_RIGHT)  tempObject.setValX(5);
				
			}  
		}
		System.out.println(key);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player) {
				// key events for player 1
				
				if(key == KeyEvent.VK_UP)  tempObject.setValY(0);
				if(key == KeyEvent.VK_DOWN)  tempObject.setValY(0);
				if(key == KeyEvent.VK_LEFT)  tempObject.setValX(0);
				if(key == KeyEvent.VK_RIGHT)  tempObject.setValX(0);
				
			}  
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	} 
}
