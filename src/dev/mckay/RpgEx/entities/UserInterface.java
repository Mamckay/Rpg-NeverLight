package dev.mckay.RpgEx.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.graphics.Assets;

public class UserInterface {
	public int x,y,width,height;
	private Player player;
	private boolean onCollision;
	public static BufferedImage currentAsset;
	public UserInterface(Handler handler,Player player) {
		
		setOnCollision(false);
		this.player = player;
		this.setWidth(341);
		this.setHeight(40);
		
	}

	
	public void tick() {
		
	}

	
	public void render(Graphics g) {
		this.x = 850;
		this.y = 30;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1200, 100);
		switch(player.getHealth()){
		case 10 : 
			this.setWidth(341);
			g.drawImage(Assets.healthBar, (int)x, (int)y, width, height, null);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		case 9 :
			this.setWidth(307);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawImage(Assets.healthBar9, (int)x, (int)y, width, height, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		case 8 :
			this.setWidth(273);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawImage(Assets.healthBar8, (int)x, (int)y, width, height, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		case 7 :
			this.setWidth(239);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawImage(Assets.healthBar7, (int)x, (int)y, width, height, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		case 6 :
			this.setWidth(205);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawImage(Assets.healthBar6, (int)x, (int)y, width, height, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		case 5 :
			this.setWidth(171);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawImage(Assets.healthBar5, (int)x, (int)y, width, height, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		case 4 :
			this.setWidth(137);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawImage(Assets.healthBar4, (int)x, (int)y, width, height, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		case 3 :
			this.setWidth(103);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawImage(Assets.healthBar3, (int)x, (int)y, width, height, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		case 2 :
			this.setWidth(69);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawImage(Assets.healthBar2, (int)x, (int)y, width, height, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		case 1 :
			this.setWidth(35);
			g.drawImage(Assets.coinUi, (int)x - 120, (int)y, 60, 32, null);
			g.drawImage(Assets.healthBar1, (int)x, (int)y, width, height, null);
			g.drawString(String.valueOf(player.getCoins()), (int)x - 50, (int)y + 20);
			break;
		}
		
		
}

	public boolean isOnCollision() {
		return onCollision;
	}

	public void setOnCollision(boolean onCollision) {
		this.onCollision = onCollision;
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
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

	
}
