package dev.mckay.RpgEx.entities.enemies;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.entities.Entity;
import dev.mckay.RpgEx.entities.Player;
import dev.mckay.RpgEx.entities.projectiles.EnergyBall;
import dev.mckay.RpgEx.entities.projectiles.HomingEnergyBall;
import dev.mckay.RpgEx.graphics.Assets;

public class EnemyTest extends Entity {
	public int  timer = 0, offX,offY;
	private boolean fire;
	private Handler handler;
	private Player player;
	public EnemyTest(Handler handler,float x, float y,Player player, Sound newBoard){
		super(handler, x, y, 70, 80, newBoard);
		this.handler = handler;
		this.player = player;
	}

	@Override
	public void tick() {
		detectPlayer();
		if (fire){
			
			handler.getWorld().getItemManager().addItem(new HomingEnergyBall(handler, x - width, y, player, 4, this.soundBoard ));
			handler.getWorld().getItemManager().addItem(new HomingEnergyBall(handler, x + width, y, player, 4, this.soundBoard ));
			handler.getWorld().getItemManager().addItem(new HomingEnergyBall(handler, x, y - height, player, 4, this.soundBoard ));
		}

	}

	@Override
	public void render(Graphics g) {
		offX = (int) (x-handler.getGameCamera().getxOffset());
		offY = (int) (y-handler.getGameCamera().getyOffset());
		//g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		//g.drawImage(Assets.hitBox, offX - 600, offY - 450,1200,900, null);
		if (health > 5){
		g.drawImage(Assets.healthyGhost, offX, offY , width, height, null);
		}
		if (health <= 5){
			g.drawImage(Assets.damagedGhost, offX, offY , width, height, null);
			}
	}

	@Override
	public void pickedUp() {

	}
	public void attack(){
		if (timer >2000){
			fire = true;
			timer = 0;
		}
		else{
			fire = false;
		}
		timer++;
	}
	public void detectPlayer(){


		// This is the detect player on screen method. Automatically attack when player in range.
		//System.out.println(player.getX());
		//System.out.println(player.getY());
		
		
		if(this.getCollisionBounds(x - 500, y - 375, 1000, 750).intersects(player.getCollisionBounds(player.getX() , player.getY(),player.getWidth()/2,player.getHeight()))){
			chase();
			attack();
		}
		

		// tower or trap like detection in a strait line. The collision is pretty precise.

		//playerOff = player.getX() - handler.getGameCamera().getxOffset();
		//if(offX - width/2 <= player.getX() - handler.getGameCamera().getxOffset() &&  offX + width/2 >= player.getX() - handler.getGameCamera().getxOffset() ){
		//System.out.println(offX);
		//System.out.println(player.getX() - handler.getGameCamera().getxOffset() );
		//fire = true;
		//}
	}
	private void chase() {
		
		
		
	}

	public void hit(){
		System.out.println("stickem like a pig");
		health--;
	}


}
