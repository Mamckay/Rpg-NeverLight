package dev.mckay.RpgEx.activatedspace;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;

public class WorldDoor extends ActiveSpace {
	public String key;
	public WorldDoor(Handler handler, int x, int y, int prtX, int prtY, String key, Sound newBoard) {
		super(handler, x, y, prtX, prtY, newBoard);
		
		this.key = key;
		
	}
	
	@Override
	public void activate(){
	handler.getWorld().worldChanger(handler.getWorld().getEntityManager().currentRoom,key);
	}
}
