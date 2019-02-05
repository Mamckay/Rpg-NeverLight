package dev.mckay.RpgEx.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;


/////the base class for all objects outside for the world generation
public abstract class Entity extends Base{
	
	protected Rectangle bounds;
	protected float w, h;
	public boolean isPlayer = false;
	protected Sound soundBoard;
	public int health = 10;
	
	public Entity(Handler handler,float x, float y, int width, int height, Sound newBoard){
		super(handler, x, y, width, height);
		this.soundBoard = newBoard;
		bounds = new Rectangle(0,0,width,height);
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public boolean checkEntityCollisionsX(){
		return true;
	}
	
	public boolean checkEntityCollisionsY(){
		return true;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset, float width, float height){
		
		return new Rectangle((int) (xOffset), (int) (yOffset), (int)width, (int)height);
	}
	
	
	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
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
	public void activated() {
		
		
	}
	public void hit(){
		
	}
}
