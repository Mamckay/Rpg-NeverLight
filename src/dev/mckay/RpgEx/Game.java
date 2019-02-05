package dev.mckay.RpgEx;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.mckay.RpgEx.display.Display;
import dev.mckay.RpgEx.graphics.Assets;
import dev.mckay.RpgEx.graphics.GameCamera;
import dev.mckay.RpgEx.inputs.KeyManager;
import dev.mckay.RpgEx.states.GameState;
import dev.mckay.RpgEx.states.MenuState;
import dev.mckay.RpgEx.states.SettingsState;
import dev.mckay.RpgEx.states.State;

public class Game implements Runnable {
	///game camera object
	private GameCamera gameCamera;
	///Handler
	private Handler handler;
	///
	private KeyManager keyManager;
	///
	//dealing with the game state
	private State gameState;
	private State menuState;
	private State settingsState;
	//
	private BufferStrategy bs;
	private Graphics g;
	private boolean running = false;
	private Thread gameThread;
	private Display display;
	public String title;
	
	private int width, height;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	
	private void init(){
		display = new Display( title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0,0);
		menuState = new MenuState(handler);
		gameState = new GameState(handler);
		settingsState = new SettingsState(handler);
		State.setState(gameState);
		
	}
	
	
	/// temp
	
	///
	
	private void tick(){
		
		keyManager.tick();
		if (State.getState() != null){
			State.getState().tick();
		}
	}
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null){
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		// clear screen
		g.clearRect(0,0, width, height);
		if (State.getState() != null){
			State.getState().render(g);
		}	
		
		
		//
		bs.show();
		g.dispose();
	}
	
	
	@Override
	public void run() {
		init();
		
		int fps = 180;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
			tick();
			render();
			ticks++;
			delta--;
			}
			if(timer >= 1000000000){
				//System.out.println("Ticks and Frames: "+ ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
		
		
	}
	public synchronized void stop(){
		if (!running)
			return;
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @return the gameCamera
	 */
	public GameCamera getGameCamera() {
		return gameCamera;
	}


	/**
	 * @param gameCamera the gameCamera to set
	 */
	public void setGameCamera(GameCamera gameCamera) {
		this.gameCamera = gameCamera;
	}


	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}


	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	public void changeState(State state){
	State.setState(state);
}
}