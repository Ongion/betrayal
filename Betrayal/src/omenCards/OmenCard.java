package omenCards;

import java.util.Locale;
import java.util.ResourceBundle;

import characters.Character;
import characters.ExplorerType;
import Game.Game;

public abstract class OmenCard {
	protected String name;
	protected String description;
	protected String rules;
	public int itemOrEvent;
	public boolean hasToken;

	protected OmenCard(String cardname, Locale loc) {
		ResourceBundle messages = ResourceBundle.getBundle("OmenCardBundle", loc);
		this.name = messages.getString("title" + cardname);
		this.description = messages.getString("des" + cardname);
		this.rules = messages.getString("rules" + cardname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String quote) {
		this.description = quote;
	}
	
	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public boolean isHauntRoll() {
	//For testing purposes, assume Haunt Roll is applicable.
		
		return Game.getInstance().getIsHaunt();
	}

	public boolean makeHauntRoll() {
		return isHauntRoll();
	}
	
	public abstract void whatToDo(Character character);
	

	
	}
