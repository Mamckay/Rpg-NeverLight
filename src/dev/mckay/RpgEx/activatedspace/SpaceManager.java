package dev.mckay.RpgEx.activatedspace;

import java.awt.Graphics;
import java.util.ArrayList;
import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.entities.Entity;
import dev.mckay.RpgEx.entities.Player;
import dev.mckay.RpgEx.activatedspace.ActiveSpace;

public class SpaceManager {
	public ArrayList <ActiveSpace> spaces ,starterTown, forestPath, citadel;
	
	public SpaceManager(Handler handler, Player player){
		spaces = new ArrayList<ActiveSpace>();
		starterTown = new ArrayList<ActiveSpace>();
		forestPath = new ArrayList<ActiveSpace>();
		citadel = new ArrayList<ActiveSpace>();
	}
	
	public void tick(){
		
		}
	
	public void render(Graphics g){
		///create a similar for loop and array list of items including weapons that will be rendered in the same loop.
	for(ActiveSpace e : spaces){
		
		e.render(g);
			
	}
	}

	/**
	 * @return the spaces
	 */
	public ArrayList<ActiveSpace> getSpaces() {
		return spaces;
	}

	/**
	 * @param spaces the spaces to set
	 */
	public void setSpaces(ArrayList<ActiveSpace> spaces) {
		this.spaces = spaces;
	}

	public void addSpaces(ActiveSpace e) {
		spaces.add(e);
	}

	public int getSpaceSize() {
		
		return spaces.size();
	}

	public void removeSpace(ActiveSpace e) {
		spaces.remove(e);
		
	}
	public void clearSpaces(){
		spaces.clear();
	}



}
