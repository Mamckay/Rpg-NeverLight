package dev.mckay.RpgEx.tiles;

import dev.mckay.RpgEx.graphics.Assets;

public class VoidTile extends Tile {
	public VoidTile(int id){
		super(Assets.voidTile, id);
	}
	@Override
	public boolean isSolid(){
		return true;
}
}
