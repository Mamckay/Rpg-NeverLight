package dev.mckay.RpgEx.entities;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;

public abstract class NonStaticEntity  extends Entity{
	
	

	/// this is a test to see what is more efficient a separate class or a just add as a extension of the creature class and render for items that can move or must follow the character graphically
	// so far i have headed a different direction from this but this class still may be useful later to instantiate the enemies or nuetral monster/ w/es
	
	  

		
		 public  NonStaticEntity(Handler handler,float x ,float y, int width, int height,Sound newBoard) {
			 super(handler,x,y,width,height,newBoard);
		 
		 }
		
	}

