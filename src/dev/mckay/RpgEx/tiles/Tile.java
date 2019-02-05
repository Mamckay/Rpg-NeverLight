package dev.mckay.RpgEx.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(10);
	public static Tile roadTile = new RoadTile(11);
	public static Tile RockTile = new RockTile(12);
	public static Tile BrickTile = new BrickTile(13);
	public static Tile DoorTile = new DoorTile(14);
	public static Tile BeatenPath = new BeatenPath(15);
	public static Tile BeatenPath2 = new BeatenPath2(16);
	public static Tile CornerPathBR = new CornerPathBR(17);
	public static Tile CornerPathBL = new CornerPathBL(18);
	public static Tile CornerPathTL = new CornerPathTL(19);
	public static Tile CornerPathTR = new CornerPathTR(20);
	public static Tile woodTile = new WoodTile(21);
	public static Tile voidTile = new VoidTile(22);
	///
	
	
	public static final int TILE_WIDTH = 128, TILE_HEIGHT = 128;
	protected BufferedImage texture;
	protected final int id;
	
public Tile(BufferedImage texture, int id) {
	this.texture = texture;
	this.id = id;
	
	tiles[id] = this;
}

public void tick(){
	
}

public void render(Graphics g, int x , int y){

	g.drawImage(texture, x, y, TILE_WIDTH,TILE_HEIGHT, null);
	
}

public boolean isSolid(){
	return false;
}

public int getId(){
	return id;
}


}
