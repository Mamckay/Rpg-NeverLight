package dev.mckay.RpgEx.entities;

import java.awt.Graphics;
import dev.mckay.RpgEx.Handler;


public abstract class Base {
	
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected boolean onCollision = true;
	
	public Base(Handler handler,float x, float y, int width, int height){
		
		this.x=x;
		this.y=y;
		this.width = width;
		this.height = height;
		this.handler = handler;
		
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);
	/**
	 * @return the handler
	 */
	public Handler getHandler() {
		return handler;
	}
	/**
	 * @param handler the handler to set
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
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
	/**
	 * @return the onCollision
	 */
	public boolean isOnCollision() {
		return onCollision;
	}
	/**
	 * @param onCollision the onCollision to set
	 */
	public void setOnCollision(boolean onCollision) {
		this.onCollision = onCollision;
	}
	public abstract void pickedUp();
	
}
