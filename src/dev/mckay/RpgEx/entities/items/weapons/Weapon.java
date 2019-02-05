package dev.mckay.RpgEx.entities.items.weapons;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.entities.items.Item;
import dev.mckay.RpgEx.graphics.Assets;
import dev.mckay.RpgEx.tiles.Tile;

public class Weapon extends Item{
	public Weapon(Handler handler, float x, float y, Sound newBoard){
		super(handler, x, y, Tile.TILE_WIDTH , Tile.TILE_HEIGHT, newBoard);
		this.description = "Sword";
	}

	@Override
	public void tick() {
		
		
	}
		
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.sword,(int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height, null);
		
		
	}

}
