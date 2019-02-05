package dev.mckay.RpgEx.worlds;

import java.awt.Graphics;
import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.activatedspace.SpaceManager;
import dev.mckay.RpgEx.entities.EntityManager;
import dev.mckay.RpgEx.entities.Player;
import dev.mckay.RpgEx.entities.UserInterface;
import dev.mckay.RpgEx.entities.items.ItemManager;
import dev.mckay.RpgEx.entities.projectiles.Projectile;
import dev.mckay.RpgEx.tiles.Tile;
import dev.mckay.RpgEx.utils.Utils;
import dev.mckay.RpgEx.LoopSound;
import dev.mckay.RpgEx.Sound;

public class World {
	
	private Player player;
	private Handler handler;
	private int width=98, height=36;
	private int[][] tiles;
	private int spawnX = 500 , spawnY = 500;
	private EntityManager entityManager;
	private ItemManager itemManager;
	private SpaceManager spaceManager;
	private WorldManager worldManager;
	private LoopSound soundLoop;
	private Sound soundBoard;
	private UserInterface userInterface;
	
	
	public World(Handler handler) {
		soundLoop = new LoopSound();
		soundBoard = new Sound();
		this.player = new Player(handler,spawnX,spawnY,soundBoard);
		this.handler = handler;
		entityManager = new EntityManager(handler, player);
		itemManager = new ItemManager(handler,player );
		spaceManager = new SpaceManager(handler,player );
		worldManager = new WorldManager(entityManager, itemManager, spaceManager, this.handler ,player, soundBoard);
		userInterface = new UserInterface(handler, player);
		worldStarter("Starter Town");
	}
	
	public void tick(){
		
		newProjectile(player.getX(),player.getY());
		entityManager.tick();
		itemManager.tick();
		
	}
	public void render(Graphics g){
		
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH );
		int xEnd=(int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILE_WIDTH + 1);
		int yStart=(int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT );
		int yEnd=(int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.TILE_HEIGHT + 1 );
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				
				getTile(x,y).render(g,(int)( x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int)( y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
				
			}
		}
		
		entityManager.render(g);
		itemManager.render(g);
		spaceManager.render(g);
		userInterface.render(g);
	}
	
	public Tile getTile(int x, int y){
		
		if(x<0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null){
			System.out.println(x);
			System.out.println(y);
			return Tile.grassTile;
		}
		return t;
	}
	
	public void loadWorld(String path){
			String file = Utils.loadFileAsString(path);
			String[] tokens = file.split("\\s+");
			this.setWidth(Utils.parseInt(tokens[0]));
			this.setHeight(Utils.parseInt(tokens[1]));
			/// time  to spawn tiles
			tiles = new int[width][height];
			
			for(int y = 0; y < height; y++){
				for(int x = 0; x < width; x++){
					tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+ 2]);
				}
			}
	}
	
	
	
	public void newProjectile(float x,float y){
		if (player.isProjectileOn() == true) {
			itemManager.addItem(new Projectile(handler,x,y,player,5.0f,soundBoard));
			player.setProjectileOn(false);
		}
		
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public ItemManager getItemManager() {
		return itemManager;
	}
	public SpaceManager getSpaceManager() {
		return spaceManager;
	}
	
	public void worldStarter(String key){
		
		this.setHeight(36);
		this.setWidth(98);
		loadWorld(worldManager.worldMap.get(key));
		spaceManager.setSpaces(worldManager.spaceMap.get(key));
		itemManager.setItems(worldManager.itemMap.get(key));
		entityManager.setEntities(worldManager.entityMap.get(key));
		entityManager.addEntity(player);
		soundLoop.playSong(worldManager.soundMap.get(key));
		
	}
	public void worldChanger(String key, String toKey){
		
		entityManager.removeEntity(player);
		loadWorld(worldManager.worldMap.get(toKey));
		entityManager.currentRoom = toKey;
		worldManager.entityMap.replace(key, entityManager.entities);
		worldManager.itemMap.replace(key,itemManager.items);
		worldManager.spaceMap.replace(key, spaceManager.spaces);
		spaceManager.setSpaces(worldManager.spaceMap.get(toKey));
		itemManager.setItems(worldManager.itemMap.get(toKey));
		entityManager.setEntities(worldManager.entityMap.get(toKey));
		entityManager.addEntity(player);
		soundLoop.playSong(worldManager.soundMap.get(toKey));
		
		}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
}
