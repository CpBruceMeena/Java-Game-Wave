package com.tutorial.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -240840600533728354L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	private Thread thread;
	
	private boolean running = false;
  	private Spawn spawner;
	private Random r;
	private Handler handler; 
	
	private HUD hud; 
	private Menu menu;
	
	public int diff = 0;
	
	// 0 means normal
	// 1 means hard
	public static boolean paused = false;
	
	public enum STATE {
		Menu, Select, Help, Game, End
	};
	 
	public static STATE gamestate = STATE.Menu;
	  
	public Game() {
		handler = new Handler();	
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		 
		new Window(WIDTH, HEIGHT, "Wave", this);
		 
		spawner = new Spawn(handler, hud, this);
		r = new Random(); 
		
		if(gamestate == STATE.Game) {

			handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player, handler));	
		  	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.EnemyBoss, handler));
			}else{
			for(int i = 0; i<15; i++) {
				handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));					
			}
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);	 
		thread.start();
		running = true; 
	}
	 
	public synchronized void stop() {
		try {
			thread.join();
			running = false; 
		}
		catch(Exception e){
			e.printStackTrace();
		}  
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
		 	delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) 
				render();
			frames++;
			
			if(System.currentTimeMillis() -  timer > 1000) {
				timer += 1000;
		//		System.out.println("FPS" + frames);
				frames = 0;
			}
		}
		stop();
 	} 
	
	private void tick() {
		
		if(gamestate == STATE.Game) {   
			
			if(!paused) {
				hud.tick();
				spawner.tick();	
				handler.tick();
				
				if(HUD.HEALTH <= 0) {
					HUD.HEALTH = 100; 
					gamestate = STATE.End;
					handler.clearEnemys();
					for(int i = 0; i<15; i++) { 
						handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));					
					}	
				}
			 }
			 
		}
		else if(gamestate == STATE.Menu || gamestate == STATE.End || gamestate == STATE.Select) {
			menu.tick(); 
	  		handler.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		 
		handler.render(g);
 		
		if(paused) {
			g.setColor(Color.white);
			g.drawString("Paused", 100, 100);
		}
		
		if(gamestate == STATE.Game) {
			hud.render(g); 
		}
		else if(gamestate == STATE.Menu || gamestate == STATE.Help || gamestate == STATE.End || gamestate == STATE.Select) {
			menu.render(g);
		}
		
		g.dispose();
		bs.show();   
	}
	
	public static int clamp(int var, int min, int max) {
			if(var >= max) return var = max;
			else if(var <= min) return var = min;
			else return var;
	}
	
	public static void main(String args[]) {
		 new Game();
	}
}
