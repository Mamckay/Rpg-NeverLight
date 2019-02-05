package dev.mckay.RpgEx.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.activatedspace.ActiveSpace;
import dev.mckay.RpgEx.entities.items.Item;
import dev.mckay.RpgEx.graphics.Assets;

public class Player extends Creature {

	private int distance, attackTimer;
	private int facing = 0;
	private int coins = 0;
	private boolean projectileOn = false;
	private boolean attackBool = false;
	private boolean onCollision, recentSpell, inventoryOn = false;
	private BufferedImage lastAttack;

	//////////////////////////////////////////////////////


	public Player(Handler handler, float x, float y,Sound newBoard) {
		super(handler,x, y , Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT, newBoard);
		t=0;
		p=0;
		bounds.x=16;
		bounds.y=32;
		bounds.width=640;
		bounds.height=1000;
		this.isPlayer = true;
		this.speed = 3;

		setOnCollision(true);
	}

	@Override
	public void tick() {
		isDead();
		attackTimer++;
		checkItemCollisions();
		Assets.animDown.tick();
		Assets.animRight.tick();
		Assets.animLeft.tick();
		Assets.animUp.tick();
		Assets.animAttackLeft.tick();
		Assets.animAttackRight.tick();
		Assets.animAttackUp.tick();
		Assets.animAttackDown.tick();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput(){
		xMove=0;
		yMove=0;
		if(handler.getKeyManager().rechargeSpell)
			rechargeSpell();
		if(handler.getKeyManager().spell)
			spell();
		if(handler.getKeyManager().attack)
			attack();
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(handler.getKeyManager().sprint){
			this.speed = speed + 3;
			Assets.animDown.setPlayerSpeed(Assets.animDown.getPlayerSpeed()*2);
			Assets.animUp.setPlayerSpeed(Assets.animUp.getPlayerSpeed()*2);
			Assets.animRight.setPlayerSpeed(Assets.animRight.getPlayerSpeed()*2);
			Assets.animLeft.setPlayerSpeed(Assets.animLeft.getPlayerSpeed()*2);
		}
		if(handler.getKeyManager().boolChecker){
			handler.getKeyManager().boolChecker = false;
			this.inventory();

		}
		if(handler.getKeyManager().boolLocation){
			nearMe();
			checkSpaceCollisions();
			handler.getKeyManager().boolLocation = false;
			this.locationDetector();
		}
	}

	private void locationDetector() {
		System.out.println(this.getX());
		System.out.println(this.getY());
		return;

	}


	private void inventory(){
		System.out.println(inventoryOn);
		if (this.inventoryOn == false){
			this.inventoryOn = true;
			return;
		}
		if (this.inventoryOn == true){
			this.inventoryOn = false;
		}

	}

	public void pickup(Item e){
		e.pickedUp();
		if(e.description == "Coin"){
			coins++;
		}
		if(e.description == "Sword"){
			coins++;
		}
	}

	private void spell() {
		if (this.recentSpell){
			return;
		}
		this.health--;
		this.recentSpell = true;

	}

	private void rechargeSpell(){
		this.recentSpell = false;
		System.out.println(health);
	}

	private void attack(){
		if (attackTimer > 100){
			attackBool = true;
			attackTimer = 0;
			for(b = handler.getWorld().getEntityManager().getEntitySize(); i < b;){
				Entity e = handler.getWorld().getEntityManager().entities.get(i);
				if(e.equals(this) != true){
					if((e.getCollisionBounds(e.getX(), e.getY(),e.getWidth(),e.getHeight()).intersects(this.getCollisionBounds(this.getX(),this.getY() ,this.getWidth(),this.getHeight())))){
						e.hit();

					}}
				i++;
			}
			i = 0;
		}
	}
	
	private void attacked(){
		if (attackBool == true){
			attackBool = false;
		}


	}


	private void isDead(){
		if (health <=0){
			System.exit(1);
		}		
	}
	public void nearMe(){
		for(b = handler.getWorld().getEntityManager().getEntitySize(); i < b;){
			Entity e = handler.getWorld().getEntityManager().entities.get(i);
			if(e.equals(this) != true){
				if((e.getCollisionBounds(e.getX(), e.getY(),e.getWidth(),e.getHeight()).intersects(this.getCollisionBounds(this.getX(),this.getY() ,this.getWidth(),this.getHeight())))){
					e.activated();
					System.out.println(e);
				}}
			i++;
		}
		i = 0;
	}

	public void checkItemCollisions(){
		for(t = handler.getWorld().getItemManager().getItemSize(); p < t;){	
			Item e = handler.getWorld().getItemManager().items.get(p);
			if(e.getCollisionBounds(e.getX(), e.getY(),e.getWidth(),e.getHeight()).intersects(this.getCollisionBounds(this.getX(),this.getY() ,this.getWidth()/2,this.getHeight()/2))){
				pickup(e);
				handler.getWorld().getItemManager().removeItem(e);
				t--;
				p--;
			}
			p++;
		}
		p=0;
	}

	// this is working just need to put in the code for what i want it to do.
	public void checkSpaceCollisions(){
		for(t = handler.getWorld().getSpaceManager().getSpaceSize(); p < t;){	
			ActiveSpace e = handler.getWorld().getSpaceManager().spaces.get(p);
			this.distance = (int) Math.sqrt((e.getX()-this.x)*(e.getX()-this.x) + (e.getY()-this.y)*(e.getY()-this.y));
			if (distance <= 100){

				e.activate();
				this.setX(e.teleX);
				this.setY(e.teleY);
				return;
			}
			p++;
		}
	}


	@Override
	public void render(Graphics g) {

		// probably should delete fake ass sword
		//g.drawImage(Assets.navi, (int)(x-handler.getGameCamera().getxOffset())+110, (int)(y - handler.getGameCamera().getyOffset())-64,width,height, null);



		g.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width , height , null);
		//if (this.inventoryOn)
		//g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()) , width , height);
		// this commented code will show the currently described hit box as of creation its named bounds
		//g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width , height);
	}

	private BufferedImage getCurrentAnimationFrame(){

		if(attackBool){
			if(this.facing == 0){
				attacked();
				width = Assets.animAttackDown.currentWidth();
				lastAttack = Assets.animAttackDown.getCurrentFrame();
				return Assets.animAttackDown.getCurrentFrame();
			}
			if(this.facing == 1){
				attacked();
				width = Assets.animAttackLeft.currentWidth();
				lastAttack = Assets.animAttackLeft.getCurrentFrame();
				return Assets.animAttackLeft.getCurrentFrame();
			}
			if(this.facing == 2){
				attacked();
				width = Assets.animAttackUp.currentWidth();
				lastAttack = Assets.animAttackUp.getCurrentFrame();
				return Assets.animAttackUp.getCurrentFrame();
			}
			if(this.facing == 3){
				attacked();
				width = Assets.animAttackRight.currentWidth();
				lastAttack = Assets.animAttackRight.getCurrentFrame();
				return Assets.animAttackRight.getCurrentFrame();
			}
		}
		if(attackTimer<50){
			return lastAttack;
		}
		if(xMove < 0){
			this.facing = 1;
			width = Assets.animLeft.currentWidth();
			return Assets.animLeft.getCurrentFrame();
		}
		if(xMove > 0){
			this.facing = 3;
			width = Assets.animRight.currentWidth();
			return Assets.animRight.getCurrentFrame();
		}
		if(yMove < 0){
			this.facing = 2;
			width = Assets.animUp.currentWidth();
			return Assets.animUp.getCurrentFrame();
		}
		if(yMove > 0){
			this.facing = 0;
			width = Assets.animDown.currentWidth();
			return Assets.animDown.getCurrentFrame();
		}
		width = Assets.animStanding.currentWidth();
		Assets.animStanding.setFacing(this.facing);
		return Assets.animStanding.getCurrentFacing();

	}

	/**
	 * @return the projectileOn
	 */
	public boolean isProjectileOn() {
		return projectileOn;
	}

	/**
	 * @param projectileOn the projectileOn to set
	 */
	public void setProjectileOn(boolean projectileOn) {
		this.projectileOn = projectileOn;
	}

	/**
	 * @return the facing
	 */
	public int getFacing() {
		return facing;
	}

	/**
	 * @param facing the facing to set
	 */
	public void setFacing(int facing) {
		this.facing = facing;
	}

	public boolean isOnCollision() {
		return onCollision;
	}

	public void setOnCollision(boolean onCollision) {
		this.onCollision = onCollision;
	}
	public void displayCoins(){

		System.out.println(coins);
	}

	/**
	 * @return the coins
	 */
	public int getCoins() {
		return coins;
	}

	/**
	 * @param coins the coins to set
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}

	@Override
	public void pickedUp() {


	}


}
