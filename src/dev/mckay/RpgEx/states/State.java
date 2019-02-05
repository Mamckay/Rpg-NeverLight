package dev.mckay.RpgEx.states;

import java.awt.Graphics;

import dev.mckay.RpgEx.Game;
import dev.mckay.RpgEx.Handler;

public abstract class State {
	
	// this is the game state manager can be separated into another class
	private static State currentState = null;
	private static State pausedState = null;
	
	public static void setState(State state){
		setPausedState(currentState);
		currentState = state ;
	}
	
	public static State getState(){
		return currentState;
	}
	///
	
	protected Handler handler;
	
	///
	protected Game game;
	
	public static void unpauseGame(){
		setState(pausedState);
	}
	
	public State(Handler handler){
		this.game = game;
		this.handler = handler;
	}
	
	/////
	public abstract void tick();
	
	public abstract void render(Graphics g);

	/**
	 * @return the pausedState
	 */
	public static State getPausedState() {
		return pausedState;
	}

	/**
	 * @param pausedState the pausedState to set
	 */
	public static void setPausedState(State pausedState) {
		State.pausedState = pausedState;
	}
	
	
}
