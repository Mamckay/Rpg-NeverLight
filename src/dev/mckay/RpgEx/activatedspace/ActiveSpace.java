package dev.mckay.RpgEx.activatedspace;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.graphics.Assets;

public class ActiveSpace extends BasicSpace{
	public int teleX,teleY;
	public Sound soundBoard;
	public ActiveSpace(Handler handler,int x, int y,int prtX,int prtY,Sound newBoard) {
		super(Assets.hitBox);	
		this.soundBoard = newBoard;
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.teleX = prtX;
		this.teleY = prtY;
	}
	
	public void render(Graphics g){
		g.drawImage(texture,(int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),100, 100, null);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return  y;
	}
	public void activate(){
		soundBoard.playSound(soundBoard.door);
	}
}
