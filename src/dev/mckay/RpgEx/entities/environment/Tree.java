package dev.mckay.RpgEx.entities.environment;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.entities.StaticEntity;
import dev.mckay.RpgEx.graphics.Assets;
import dev.mckay.RpgEx.tiles.Tile;

public class Tree extends StaticEntity{
	public Tree(Handler handler, float x, float y,Sound newBoard){
		super(handler, x, y, Tile.TILE_WIDTH , Tile.TILE_HEIGHT, newBoard );
		bounds.x = 128;
		bounds.y = 128;
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		//System.out.println(this.getX());
		//System.out.println(this.getY());
		g.drawImage(Assets.tree,(int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width,height, null);
		
	}

	@Override
	public void pickedUp() {
		// TODO Auto-generated method stub
		
	}

}
