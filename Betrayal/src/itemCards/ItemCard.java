package itemCards;

import java.util.Locale;
import java.util.ResourceBundle;

import characters.Character;

public abstract class ItemCard {
	protected String name;
	protected String description;
	protected String desDetail;
	protected String cardName;
	public boolean isLost;
	public int numRolls;
	

	
	public ItemCard(String cardname, Locale loc){
		this.cardName = cardname;
		
		ResourceBundle messages = ResourceBundle.getBundle("ItemCardBundle", loc);
		this.name = messages.getString("title" + cardname);
		this.description = messages.getString("des" + cardname);
		this.desDetail = messages.getString("detail" + cardname);
		
	}
	
	//This is different than getName, in the it returns the always English name
	//Not one that has been localized. Used to pick correct image, for example.
	public String getCardName() {
		return this.cardName;
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
	
	public String getDetails(){
		return desDetail;
	}
	
	public void setDetails(String details){
		this.desDetail = details;
	}

	public abstract void whatToDo(Character character);

}
