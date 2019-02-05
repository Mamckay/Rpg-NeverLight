package dev.mckay.RpgEx.entities.npcs;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.entities.Entity;
import dev.mckay.RpgEx.entities.StaticEntity;
import dev.mckay.RpgEx.graphics.Assets;

public class Guard extends Entity {
	int width =64; 
	int height = 64;
	boolean activated = false;
	int timer;
	public Sound soundBoard;
	
	public Guard(Handler handler, float x, float y, Sound newBoard) {
		super(handler, x, y, 128, 128, newBoard);
		this.soundBoard = newBoard;
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void tick() {
		if (activated && timer<120){
			timer++;
			return;
		}
		activated = false;
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.protectron,(int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),128,128, null);
		if (activated){
			g.drawImage(Assets.dialougeBox,(int)(x-handler.getGameCamera().getxOffset())+ 64, (int)(y - handler.getGameCamera().getyOffset()-128),128,128, null);
		}
	}
	
	@Override
	public void activated(){
		
		soundBoard.playSound(soundBoard.robot);
		
	}

	@Override
	public void pickedUp() {
		// TODO Auto-generated method stub
		
	}
	public void hit(){
		activated();
	}
	
}
