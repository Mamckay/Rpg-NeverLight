package dev.mckay.RpgEx.states;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.worlds.World;

public class GameState extends State{
	

	private World world;

	
	public GameState(Handler handler) {
		super( handler);
		world = new World(handler);
		handler.setWorld(world);
		
	}
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		
		
	}

	
	
	
}
