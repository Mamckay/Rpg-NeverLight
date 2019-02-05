package dev.mckay.RpgEx.saves;

public class Inventory {
	int coins = 0;
	int bombs = 0;
	int potions = 0;
	public Inventory(){
				
	}
	
	public int getCoins(){
		return coins;
	}
	public void addCoin(){
		coins++;
	}
	public void addbomb(){
		bombs++;
	}
	public void addpotion(){
		potions++;
	}
	
	/**
	 * @return the bombs
	 */
	public int getBombs() {
		return bombs;
	}

	/**
	 * @param bombs the bombs to set
	 */
	public void setBombs(int bombs) {
		this.bombs = bombs;
	}

	/**
	 * @return the potions
	 */
	public int getPotions() {
		return potions;
	}

	/**
	 * @param potions the potions to set
	 */
	public void setPotions(int potions) {
		this.potions = potions;
	}

	/**
	 * @param coins the coins to set
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	
}
