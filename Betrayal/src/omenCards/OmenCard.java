package omenCards;

import Game.Game;

public abstract class OmenCard {
	protected String name;
	protected String quote;

	protected OmenCard(String name, String quote) {
		this.name = name;
		this.quote = quote;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public boolean isHauntRoll() {
	//For testing purposes, assume Haunt Roll is applicable.
		
		return Game.getInstance().getIsHaunt();
	}

	public boolean makeHauntRoll() {
		if(isHauntRoll()){
			return true;
		}
		return false;
		
	}

	public abstract Object whatToDo();
}