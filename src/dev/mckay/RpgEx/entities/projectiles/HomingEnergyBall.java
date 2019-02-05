package dev.mckay.RpgEx.entities.projectiles;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.entities.Player;
import dev.mckay.RpgEx.graphics.Assets;

public class HomingEnergyBall extends EnergyBall {
	protected float speed, xSpeed= 0, ySpeed= 0;
	private Player player;

	public HomingEnergyBall(Handler handler, float x, float y, Player player, float speed, Sound newBoard) {
		super(handler, x, y, player, speed, newBoard);
		this.player = player;
		this.speed = speed;
	}

	@Override
	public void tick(){

		move();

	}

	@Override
	public void render(Graphics g) {


		g.drawImage(Assets.energyBall,(int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),43,42, null);

	}

	public void move(){
		// this method is very clean and has a max speed of 5 pixels per frames per second gottem coach XD
		x += xSpeed;
		y += ySpeed;



		if (this.getX()> player.getX()){
			xSpeed -= .09;

		} 
		if( this.getX() <  player.getX()){
			xSpeed += .09;
		}
		if (this.getY()> player.getY()){

			ySpeed -= .09;

		} 
		if( this.getY() < player.getY() ){

			ySpeed += .09;
		}
		if(xSpeed > 5){
			xSpeed = 5;
		}
		if(ySpeed > 5){
			ySpeed = 5;
		}
		if(xSpeed < -5){
			xSpeed = -5;
		}
		if(ySpeed < -5){
			ySpeed = -5;
		}

		// kinda crappy follower tech. Goi8ng to add a sling or gravity type of movement to it.

		//		if (this.getX()> player.getX()){
		//			this.setX(this.getX() - speed);
		//
		//		} 
		//		if( this.getX() <  player.getX()){
		//			this.setX(this.getX() + speed);
		//		}
		//		if (this.getY()> player.getY()){
		//			this.setY(this.getY() - speed);
		//
		//		} 
		//		if( this.getY() < player.getY() ){
		//			this.setY(this.getY() + speed);
		//		}
	}


}
