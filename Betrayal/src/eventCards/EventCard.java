package eventCards;
import characters.Character;

public abstract class EventCard {

	protected String name;
	protected String description;
	
	protected EventCard(String name, String description){
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
	
	public abstract void happen(int rollResult);
	// rollResult will be removed. It is only for testing purposes
	
	public abstract void happens();
	
	public abstract Character getCharacter();
	// for testing purposes only and will be removed
	
}
