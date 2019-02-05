package dev.mckay.RpgEx.graphics;

import java.awt.image.BufferedImage;

public class Animation {
	private int speed, index;
	//this needs to be tested then reworked to a better class
	private float playerSpeed = 2;
	private long lastTime, timer;
	private BufferedImage[] frames;
	private int facing = 0, width[] = {0,0,0,0}, height[] = {0,0,0,0};
	
	public Animation(int speed, BufferedImage[] frames){
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	

	
	
	public void tick(){
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > (int)speed/playerSpeed){
			index++;
			timer = 0;
			if(index >= frames.length)
				index = 0;
		}
	}
	
	// this is a method that tests the solid facing pattern of movement
	// tested and it was a great success XD
	
	public BufferedImage getCurrentFacing(){
		return frames[facing];
		
	}
	
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}

	/**
	 * @return the playerSpeed
	 */
	public float getPlayerSpeed() {
		return playerSpeed;
	}

	/**
	 * @param playerSpeed the playerSpeed to set
	 */
	public void setPlayerSpeed(float playerSpeed) {
		this.playerSpeed = playerSpeed;
	}

	/**
	 * @return the facing
	 */
	public int getFacing() {
		return facing;
	}

	/**
	 * @param facing the facing to set
	 */
	public void setFacing(int facing) {
		this.facing = facing;
	}




	public int[] getWidth() {
		return width;
	}
	
	public int currentWidth(){
		return width[index];
	}


	public void addMeasurements(int a,int b,int c ,int d , int e, int f, int g, int h) {
		width[0] = a;
		width[1] = b;
		width[2] = c;
		width[3] = d;
		height[0] = e;
		height[1] = f;
		height[2] = g;
		height[3] = h;
	}
}
