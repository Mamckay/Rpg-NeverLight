package dev.mckay.RpgEx.states;

import java.awt.Graphics;

import dev.mckay.RpgEx.Game;
import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.graphics.ImageLoader;
import dev.mckay.RpgEx.graphics.SpriteSheet;
import dev.mckay.RpgEx.MenuManager;

public class MenuState extends State {
	private MenuManager beginMenu;
	private SpriteSheet menu;
	
	public MenuState( Handler handler) {
		super( handler);
		this.beginMenu = new MenuManager();
		//SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("/textures/protectron.png"));
	}

	@Override
	public void tick() {
		
	
	
	}

	@Override
	public void render(Graphics g) {
	
		this.beginMenu.render(g);
		
	}

}
