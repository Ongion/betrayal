package itemCards;

import characters.Character;

public abstract class ItemCard {
	protected String name;
	protected String description;
	public boolean isLost;
	

	
	public ItemCard(String name, String description){
		this.name = name;
		this.description = description;
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

	public abstract void whatToDo(Character character);

}
