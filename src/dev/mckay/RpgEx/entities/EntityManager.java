package dev.mckay.RpgEx.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import dev.mckay.RpgEx.Handler;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	public ArrayList <Entity> entities, starterTown, forestPath, citadel;
	public String currentRoom;
	
	public EntityManager(Handler handler, Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		starterTown = new ArrayList<Entity>();
		forestPath = new ArrayList<Entity>();
		citadel = new ArrayList<Entity>();
		addEntity(player);
	}
	public void tick(){
		for(int i = 0 ; i< entities.size(); i++){
			Entity e = entities.get(i);
			e.tick();
			if (e.health <=0){
				entities.remove(e);
			}
		}
		// Item entity and space manager render sort off
		//entities.sort(renderSorter);
	}

	public void render(Graphics g){
		for(Entity e : entities){
			
			e.render(g);	
		}
	}
	
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY()+a.getHeight() < b.getY()+ b.getHeight())
				return -1;
			return 1;
		}
	};
	
	public void safeClear(){
		int x=0;
		int y=0;
		for(x = entities.size(); y < x;){
			Entity e = entities.get(y);
			entities.remove(e);
			x--;
		}
		}
	
	
	public void removeEntity(Entity e){
		entities.remove(e);
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	/**
	 * @return the handler
	 */
	public Handler getHandler() {
		return handler;
	}
	/**
	 * @param handler the handler to set
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	/**
	 * @return the entities
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	/**
	 * @param entities the entities to set
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	/**
	 * @return the entitySize
	 */
	public int getEntitySize() {
		return entities.size();
	}
	
	
	
	////
	
	
	
}
