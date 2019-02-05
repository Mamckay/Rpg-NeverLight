package dev.mckay.RpgEx.entities;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.graphics.Assets;


/// i really need to change the location of this class so its not so confusing. I guess that the followers will be classified as non entities.

// this class needs to be changed into an abstract class and ext4ended to the other followers.

public class Follower extends Entity {
	
	protected int health;
	protected float speed;
	private Player player;
	
	public Follower(Handler handler, float x, float y, Player player, float speed,Sound newBoard) {
		super(handler,x, y , Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT, newBoard);
		this.player = player;
		this.speed = speed;
		this.setOnCollision(false);
	}

	public void followingPlayer(Player player){
		if (this.getX()> player.getX() + 75){
			this.setX(this.getX() - 2);
				
			} 
		if( this.getX() <  player.getX() - 75){
			this.setX(this.getX() + 2);
		}
		if (this.getY()> player.getY()+ 75 ){
			this.setY(this.getY() - 2);
				
			} 
		if( this.getY() < player.getY() - 75){
			this.setY(this.getY() + 2);
		}
		}
		
	
	
	@Override
	public void tick() {

		followingPlayer(this.player);
		
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.navi, (int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width,height, null);
		
	}

	@Override
	public void pickedUp() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void activated(){
		
		//soundBoard.playSound(soundBoard.littleHey);
		
	}
	public void hit(){
		//activated();
	}

}
