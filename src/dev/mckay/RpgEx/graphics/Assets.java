package dev.mckay.RpgEx.graphics;

import java.awt.image.BufferedImage;

public class Assets {
		
		private static final int width=100, height=94 ;
		public static BufferedImage  healthyGhost,damagedGhost,energyBall, shopKeeper,dialougeBox,voidTile,woodTile,healthBar,healthBar1,healthBar2,healthBar3,healthBar4,healthBar5,healthBar6,healthBar7,healthBar8,healthBar9,navi,sword, tree, stone1, stone2, stone3, road, lava, grass, monkeyKing, projectile, door, beatenPath, beatenPath2,cornerPathTL,cornerPathBR,cornerPathTR,cornerPathBL, protectron,smallCoin,hitBox,coinUi;
		public static BufferedImage[] player_down, player_up, player_right, player_left, player_standing
		,attack_left,attack_right,attack_up,attack_down,block_down,block_up,block_left,block_right;
		public static Animation animDown,animUp,animRight,animLeft,animStanding,animAttackLeft, animAttackRight,animAttackUp,animAttackDown;
		
		
		public static void init() {	
		
		SpriteSheet sheet  = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteNew.png"));
		SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/textures/gutswalk.png"));
		SpriteSheet playerDefend = new SpriteSheet(ImageLoader.loadImage("/textures/gutsblock.png"));
		SpriteSheet playerAttack = new SpriteSheet(ImageLoader.loadImage("/textures/gutsattack.png"));
		SpriteSheet npcs = new SpriteSheet(ImageLoader.loadImage("/textures/protectron.png"));
		
		///
		player_standing= new BufferedImage[4];
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_left = new BufferedImage[2];
		
		///
		player_standing[0] = player.crop( 0, 0, 49, 79);
		player_standing[1] = player.crop( 0,79, 49, 79);
		player_standing[2] = player.crop( 0,79*3, 49, 79);
		player_standing[3] = player.crop( 0,79*2, 49, 79);
		player_down[0] = player.crop( 49,0, 49, 79);
		player_down[1] = player.crop(  49*2,0, 49, 79);
		player_right[0] = player.crop( 49,79*2, 49, 79);
		player_right[1] = player.crop( 49*2,79*2, 49, 79);
		player_left[0] = player.crop( 49,79, 49, 79);
		player_left[1] = player.crop( 49*2,79, 49, 79);
		player_up[0] = player.crop(  49,79*3, 49, 79);
		player_up[1] = player.crop(  49*2,79*3, 49, 79);
		///
		
		
		
		///
		attack_left = new BufferedImage[1];
		attack_right = new BufferedImage[1];
		attack_down = new BufferedImage[1];
		attack_up = new BufferedImage[1];
		
		
		///
//		attack_left[0] = playerAttack.crop(42, 104, 41, 85);
		attack_left[0]= playerAttack.crop(143, 111, 84, 77);
//		attack_left[2]= playerAttack.crop(323, 111, 49, 77);
//		
//		attack_right[0]= playerAttack.crop(39, 193, 45, 89);
		attack_right[0]= playerAttack.crop(207, 205, 81, 76);
//		attack_right[2]= playerAttack.crop(352, 205, 42, 76);
				
		attack_up[0]= playerAttack.crop(36, 283, 43, 91);
//		attack_up[1]= playerAttack.crop(188, 294, 34, 78);
//		attack_up[2]= playerAttack.crop(332, 294, 34, 78);
				
//		attack_down[0]= playerAttack.crop(45, 7, 47, 83);
		attack_down[0]= playerAttack.crop(192, 16, 43, 77);
//		attack_down[2]= playerAttack.crop(335, 20, 42, 74);
		
	
		
		block_left= new BufferedImage[3];
		block_right= new BufferedImage[3];
		block_down= new BufferedImage[3];
		block_up= new BufferedImage[3];
		
		///
		
		navi = sheet.crop(100*8, 128, 100, 128);
		sword = sheet.crop(100*7, 128, 100, 128);
		tree = sheet.crop(100*6 , 128, 100, 128);
		stone1 = sheet.crop(100*2, 128, 100, 128);
		stone2 = sheet.crop(100*3, 128, 100, 128);
		stone3 = sheet.crop(100*4, 128, 100, 128);
		grass = sheet.crop(0, 128, 100, 128);
		lava = sheet.crop(100*1, 128, 100, 128);
		road = sheet.crop(100*5, 128, 100, 128);
		monkeyKing = sheet.crop(0, 0, 100, 128);
		projectile = sheet.crop(900, 160, 85, 40);
		door = sheet.crop(1, 376, 100, 128);
		beatenPath = sheet.crop(0, 505, 100, 128);
		beatenPath2 = sheet.crop(500 , 504, 100, 128);
		cornerPathTL = sheet.crop(100,  504, 100, 128);
		cornerPathTR = sheet.crop(400,  504, 100, 128);
		cornerPathBL = sheet.crop(201,  504, 100, 128);
		cornerPathBR = sheet.crop(300,  504, 100, 128);
		voidTile = sheet.crop(500, 256, 100, 128);
		woodTile = sheet.crop(628, 256, 100, 128);
		healthBar = sheet.crop(100, 376, 341, 44);
		healthBar1 = sheet.crop(100, 376, 35, 44);
		healthBar2 = sheet.crop(100, 376, 69, 44);
		healthBar3 = sheet.crop(100, 376, 103, 44);
		healthBar4 = sheet.crop(100, 376, 137, 44);
		healthBar5 = sheet.crop(100, 376, 171, 44);
		healthBar6 = sheet.crop(100, 376, 205, 44);
		healthBar7 = sheet.crop(100, 376, 239, 44);
		healthBar8 = sheet.crop(100, 376, 273, 44);
		healthBar9 = sheet.crop(100, 376, 307, 44);
		protectron = npcs.crop(0, 0, 128, 128);
		smallCoin = sheet.crop(131, 301, 31, 32);
		coinUi = sheet.crop(131, 301, 60, 32);
		hitBox = sheet.crop(756, 256, 100, 100);
		dialougeBox = sheet.crop(700, 504, 201, 138);
		shopKeeper = sheet.crop(101, 657, 107, 96);
		energyBall = sheet.crop(225, 691, 43, 42);
		healthyGhost = sheet.crop(312, 285, 73, 72);
		damagedGhost = sheet.crop(208, 285, 73, 68);
		
		
		
		/// Initialize the animations here
		animDown = new Animation(800,Assets.player_down);
		animRight = new Animation(800,Assets.player_right);
		animLeft = new Animation(800,Assets.player_left);
		animUp = new Animation(800,Assets.player_up);
		animStanding = new Animation(800, Assets.player_standing);
		animAttackLeft = new Animation(300, Assets.attack_left);
		animAttackUp = new Animation(300, Assets.attack_up);
		animAttackDown = new Animation(300, Assets.attack_down);
		animAttackRight = new Animation(300, Assets.attack_right);
		
		/// initialize the width arrays here
		animDown.addMeasurements(49,49,49,49,79,79,79,79);
		animRight.addMeasurements(49,49,49,49,79,79,79,79);
		animLeft.addMeasurements(49,49,49,49,79,79,79,79);
		animUp.addMeasurements(49,49,49,49,79,79,79,79);
		animStanding.addMeasurements(49,49,49,49,79,79,79,79);
		animAttackLeft.addMeasurements(84, 49, 0, 85 , 77, 77 , 0,0);
		animAttackRight.addMeasurements(81,81,42,0,76,76,76,0);
		animAttackDown.addMeasurements(43,43,42,0, 77,77,74,0);
		animAttackUp.addMeasurements(43,34,34,0,91,78,78,0);
		
		}

}
