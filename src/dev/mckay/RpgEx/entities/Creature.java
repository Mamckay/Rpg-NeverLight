package dev.mckay.RpgEx.entities;

import java.awt.Graphics;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.tiles.Tile;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10 ;
	public static final float DEFAULT_SPEED = 6.0f;
	public static final int DEFAULT_CREATURE_WIDTH= 64,
			DEFAULT_CREATURE_HEIGHT= 64;
	protected int health,b,i,t,p;
	protected float speed, xMove, yMove;
	
	
	public Creature(Handler handler,float x, float y, int width, int height, Sound newBoard) {
		super(handler,x, y, width, height, newBoard);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		i=0;
		b=0;
	}

	@Override
	public abstract void tick();

	@Override
	public abstract void render(Graphics g);
	
	
	public boolean checkEntityCollisionsX(int x){
		for(b = handler.getWorld().getEntityManager().getEntitySize(); i < b;){
			Entity e = handler.getWorld().getEntityManager().entities.get(i);
			if(e.equals(this) != true){
				if(e.onCollision && e.getCollisionBounds(e.getX(), e.getY(),e.getWidth(),e.getHeight()).intersects(this.getCollisionBounds(x , this.getY(),this.getWidth()/2,this.getHeight()))){
//					System.out.println("Collision Detected");
//					System.out.println(e.getCollisionBounds(e.getX(), e.getY(),e.getWidth(),e.getHeight()));
					return false;}}
				i++;
			}
				i = 0;
				return true;}
	
	
	public boolean checkEntityCollisionsY(int y){
		for(b = handler.getWorld().getEntityManager().getEntitySize(); i < b;){
			Entity e = handler.getWorld().getEntityManager().entities.get(i);
			if(e.equals(this) != true){
				if(e.onCollision && e.getCollisionBounds(e.getX(), e.getY(),e.getWidth(),e.getHeight()).intersects(this.getCollisionBounds(this.getX(), y ,this.getWidth()/2,this.getHeight()/2))){
//					System.out.println("Collision Detected");
//					System.out.println(e);
					return false;}}
				i++;
			}
				i = 0;
				return true;
			}
	
	
	public void move(){
			moveX();
			moveY();
	}
	public void moveX(){
		if(xMove > 0 || xMove < 0){//Moving right
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			int tex = (int) (x + xMove + bounds.x);
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT ) && checkEntityCollisionsX(tex)){
				x += xMove;
			}
		}
		}
	
	public void moveY(){
		if(yMove < 0 || yMove > 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			int tey = (int) (y + yMove + bounds.y);
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) && checkEntityCollisionsY(tey) ){
				y += yMove;
			}
		}
		}
	
	protected boolean collisionWithTile(int x, int y){
		
		return handler.getWorld().getTile(x, y).isSolid();
		
	}
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return the xMove
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * @param xMove the xMove to set
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return the yMove
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * @param yMove the yMove to set
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
