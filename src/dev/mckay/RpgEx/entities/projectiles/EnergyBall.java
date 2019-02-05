package dev.mckay.RpgEx.entities.projectiles;

import java.awt.Graphics;
import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.entities.Creature;
import dev.mckay.RpgEx.entities.Player;
import dev.mckay.RpgEx.entities.items.Item;
import dev.mckay.RpgEx.graphics.Assets;

public class EnergyBall extends Item {
	protected int health;
	protected float speed;
	private Player player;
	private int facing = 0;
		
		public EnergyBall(Handler handler, float x, float y, Player player, float speed,Sound newBoard) {
			super(handler,x, y , Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT, newBoard);
			this.player = player;
			this.speed = speed;
		}

		@Override
		public void tick() {
			
			move();		 
		}

		private void move() {
			x = x + 5;
			
		}

		@Override
		public void render(Graphics g) {
			
			g.drawImage(Assets.energyBall,(int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),43,42, null);
		}
		
		@Override
		public void pickedUp(){
			//player.setHealth(player.getHealth()-1);
		}
		
		

	}


