package dev.mckay.RpgEx.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up,down,left,right,sprint, attack, spell, inventory , rechargeSpell , boolChecker, boolLocation;
	
	
	public KeyManager(){
		keys = new boolean[256];
		
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		sprint = keys[KeyEvent.VK_L];
		attack = keys[KeyEvent.VK_K];
		spell = keys[KeyEvent.VK_U];
		rechargeSpell = keys[KeyEvent.VK_I];
	
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
			
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// not used
		if (e.getKeyChar() == 'r'){
			this.boolChecker = true;
			return;
		}
		if (e.getKeyChar() == 'e'){
			this.boolLocation = true;
			return;
		}
	}

}
