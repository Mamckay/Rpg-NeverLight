package dev.mckay.RpgEx.worlds;

import java.util.ArrayList;
import java.util.HashMap;

import dev.mckay.RpgEx.Handler;
import dev.mckay.RpgEx.Sound;
import dev.mckay.RpgEx.activatedspace.ActiveSpace;
import dev.mckay.RpgEx.activatedspace.SpaceManager;
import dev.mckay.RpgEx.activatedspace.WorldDoor;
import dev.mckay.RpgEx.entities.Entity;
import dev.mckay.RpgEx.entities.EntityManager;
import dev.mckay.RpgEx.entities.Follower;
import dev.mckay.RpgEx.entities.Player;
import dev.mckay.RpgEx.entities.enemies.EnemyTest;
import dev.mckay.RpgEx.entities.environment.Tree;
import dev.mckay.RpgEx.entities.items.Coin;
import dev.mckay.RpgEx.entities.items.Item;
import dev.mckay.RpgEx.entities.items.ItemManager;
import dev.mckay.RpgEx.entities.items.weapons.Weapon;
import dev.mckay.RpgEx.entities.npcs.Guard;
import dev.mckay.RpgEx.entities.npcs.ShopKeeper;

public class WorldManager {
	public EntityManager entityManager; 
	public ItemManager itemManager; 
	public SpaceManager spaceManager;
	public Player player;
	public Handler handler;
	public HashMap<String, ArrayList<Entity>> entityMap = new HashMap<String, ArrayList<Entity>>();
	public HashMap<String, String> worldMap = new HashMap<String, String>();
	public HashMap<String, ArrayList<Item>> itemMap = new HashMap<String, ArrayList<Item>>();
	public HashMap<String, ArrayList<ActiveSpace>> spaceMap = new HashMap<String, ArrayList<ActiveSpace>>();
	public HashMap<String, String> soundMap = new HashMap<String, String>();
	public Sound soundBoard;
	
	public WorldManager(EntityManager entityManager, ItemManager itemManager, SpaceManager spaceManager,Handler handler,Player player, Sound newBoard){
		
		this.soundBoard = newBoard;
		this.entityManager = entityManager;
		this.itemManager = itemManager;
		this.spaceManager = spaceManager;
		this.handler = handler;
		this.player = player;
		initializeHashmaps();
		
	}
	
	
	
	public void initializeHashmaps(){
		
		itemManager.starterTown.add(new Weapon(handler,entityManager.getPlayer().getX(),entityManager.getPlayer().getY(),soundBoard));
		itemManager.starterTown.add(new Coin(handler,1000,700,30,30,soundBoard));
		itemManager.starterTown.add(new Coin(handler,player.getX(),player.getY(),30,30,soundBoard));
		spaceManager.starterTown.add(new ActiveSpace(handler,2830,2600,11736,802, soundBoard));
		spaceManager.starterTown.add(new ActiveSpace(handler,11796,928,2843,2609, soundBoard));
		spaceManager.starterTown.add(new ActiveSpace(handler,11660,928,2843,2609, soundBoard));
		spaceManager.starterTown.add(new WorldDoor(handler,500,500,1202,9710, "Forest Path",soundBoard));
		spaceManager.forestPath.add(new WorldDoor(handler,1202,9710,500,500, "Starter Town",soundBoard));
		entityManager.starterTown.add(new Tree(handler,300,350, soundBoard));
		entityManager.starterTown.add(new Tree(handler,520,340, soundBoard));
		entityManager.starterTown.add(new Tree(handler,400,650, soundBoard));
		entityManager.starterTown.add(new Guard(handler,2600,2688, soundBoard));
		entityManager.starterTown.add(new Guard(handler,3000,2688, soundBoard));
		entityManager.starterTown.add(new Follower(handler,400,350,player,5.0f, soundBoard));
		entityManager.forestPath.add(new Follower(handler,400,350,player,5.0f, soundBoard));
		entityManager.forestPath.add(new Guard(handler,300,268, soundBoard));
		entityManager.starterTown.add(new ShopKeeper(handler,11748,244, soundBoard));
		entityManager.starterTown.add(new EnemyTest(handler,1000,1000,player, soundBoard));
		entityMap.put("Starter Town", entityManager.starterTown);
		entityMap.put("Forest Path", entityManager.forestPath);
		worldMap.put("Starter Town","res/worlds/world1.txt");
		worldMap.put("Forest Path","res/worlds/forestpath.txt");
		itemMap.put("Starter Town", itemManager.starterTown);
		itemMap.put("Forest Path", itemManager.forestPath);
		spaceMap.put("Starter Town",spaceManager.starterTown);
		spaceMap.put("Forest Path", spaceManager.forestPath);
		soundMap.put("Starter Town", "/res/soundFiles/adventure.wav");
		soundMap.put("Forest Path", "/res/soundFiles/hyrule.wav");
		soundMap.put("Citadel", "/res/soundFiles/sandstorm.wav");
	}
	
}
