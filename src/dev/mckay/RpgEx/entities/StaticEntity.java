package dev.mckay.RpgEx.entities;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;

////treeessss and block ect outside of wthe world genereation

public abstract class StaticEntity extends Entity{

	
	 public StaticEntity(Handler handler,float x ,float y, int width, int height, Sound newBoard) {
		 super(handler,x,y,width,height, newBoard);
	 
	 }
	
}
