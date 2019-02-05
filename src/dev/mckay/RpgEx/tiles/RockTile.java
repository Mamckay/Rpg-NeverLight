package dev.mckay.RpgEx.tiles;

import dev.mckay.RpgEx.graphics.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
	
		super(Assets.stone1, id);

	}

	@Override
	public boolean isSolid(){
		return true;
}

}
