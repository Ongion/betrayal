package eventCards;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class EventCard {

	protected String name;
	protected String description;
	protected String rules;
	
	protected EventCard(String cardname, Locale loc){
		ResourceBundle messages = ResourceBundle.getBundle("EventCardBundle", loc);
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

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRules(){
		return this.rules;
	}
	
	public void setRules(String rules){
		this.rules = rules;
	}
	
	public abstract void happen(int rollResult);
	// rollResult will be removed. It is only for testing purposes
	
	public abstract void happens();
	
	public void beginningOfTurn(){
		// Only implemented in cards that are added to character hands
	}
	
	public String toString() {
		return this.getName();
	}
	
}
