package omenCards;

import characters.Character;
import characters.Explorer;
import Game.Game;

public abstract class OmenCard {
	protected String name;
	protected String quote;
	public int itemOrEvent;

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
		return isHauntRoll();
	}
	
	public abstract void whatToDo(Explorer character, Game game);
	

	
	}
