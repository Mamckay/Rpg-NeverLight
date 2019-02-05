package dev.mckay.RpgEx.entities.items;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.entities.Base;

public class Item extends Base {
	public String description = "default";
	public Sound soundBoard;
	public Item(Handler handler, float x, float y, int width, int height ,Sound newBoard) {
		super(handler, x, y, width, height);
		this.soundBoard = newBoard;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public Rectangle getCollisionBounds(float xOffset, float yOffset, float width, float height){
		
		return new Rectangle((int) (xOffset), (int) (yOffset), (int)width, (int)height);
	}
	
	
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void pickedUp() {
		
	}
	
	
}
