package dev.mckay.RpgEx.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		// TODO Auto-generated constructor stub
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
		
		
		return sheet.getSubimage(x, y, width, height);
		
	}
}
