package dev.mckay.RpgEx.entities.npcs;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.entities.Entity;
import dev.mckay.RpgEx.graphics.Assets;

public class ShopKeeper extends Entity {
	int width =64; 
	int height = 64;
	boolean activated = false;
	int timer;
	Sound soundBoard;
	public ShopKeeper(Handler handler, float x, float y, Sound newBoard){
		super(handler, x, y, 128, 128, newBoard);
		this.soundBoard = newBoard;
		
	}
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.shopKeeper,(int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),128,128, null);
		
	}
	
	@Override
	public void activated(){
		
		soundBoard.playSound(soundBoard.shopHey);
		
	}

	@Override
	public void pickedUp() {
		// TODO Auto-generated method stub
		
	}
	
}
