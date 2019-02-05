package dev.mckay.RpgEx.entities.items;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.graphics.Assets;

public class Coin extends Item {
	
	public Coin(Handler handler, float x, float y, int width, int height,Sound newBoard) {
		super(handler, x, y, width, height, newBoard);
		this.description = "Coin";
	}

	@Override
	public void tick() {
			 
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.smallCoin,(int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width,height, null);
	}
	
	@Override
	public void pickedUp(){
		this.soundBoard.playSound(soundBoard.coin);
	}
	

}
