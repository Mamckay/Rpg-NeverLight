package dev.mckay.RpgEx.entities.projectiles;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.entities.Creature;
import dev.mckay.RpgEx.entities.Player;
import dev.mckay.RpgEx.entities.items.Item;
import dev.mckay.RpgEx.graphics.Assets;

public class Projectile extends Item{

	protected int health;
	protected float speed;
	private Player player;
	private int facing = 0;
	
	public Projectile(Handler handler, float x, float y, Player player, float speed,Sound newBoard) {
		super(handler,x, y , Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT, newBoard);
		this.player = player;
		this.speed = speed;
		this.facing = player.getFacing();
	}

	@Override
	public void tick() {
		
		if (facing == 0)
			y = y + 5;
		if (facing == 1)
			x = x - 5;
		if (facing == 2)
			y = y - 5;
		if (facing == 3)
			x = x + 5;		 
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.projectile,(int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width,height, null);
	}
	
	@Override
	public void pickedUp(){
		player.setHealth(player.getHealth()-1);
	}

}
