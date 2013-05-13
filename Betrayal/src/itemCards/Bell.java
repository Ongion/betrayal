package itemCards;

import java.util.Locale;

import characters.Character;

public class Bell extends ItemCard {

	public Bell(Locale loc) {
		super("Bell", loc);
		
	}

	@Override
	public
	void whatToDo(Character character) {
		character.incrementSanity();
		if(!character.getItemHand().contains(this)){
			character.decrementSanity();
		}
	}

}
