package dev.mckay.RpgEx.entities.items;

import java.awt.Graphics;
import java.util.ArrayList;
import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.entities.Entity;
import dev.mckay.RpgEx.entities.Player;

public class ItemManager {
	
	private Handler handler;
	private Player player;

	public ArrayList <Item> items,starterTown,forestPath,citadel;
	
	public ItemManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		items = new ArrayList<Item>();
		starterTown = new ArrayList<Item>();
		forestPath = new ArrayList<Item>();
		citadel = new ArrayList<Item>();
		
		
	
	 }
	 
	public void tick(){
		for(int i = 0 ; i< items.size(); i++){
			Item e = items.get(i);
			e.tick();
		}
		//Item entitiy and space manager render sort off
		//items.sort(renderSorter);
	}

	public void render(Graphics g){
			///create a similar for loop and array list of items including weapons that will be rendered in the same loop. also try to make the loop more efficientnv
		for(Item e : items){
			e.render(g);
		}
		}
	
	public void addItem(Item e){
		items.add(e);
		}
	
	public int getItemSize() {
		return items.size();
	}
	
	public void removeItem(Item e){
		items.remove(e);
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
