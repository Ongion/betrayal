package itemCards;

import java.util.Locale;

import characters.Character;

public class AmuletOfAges extends ItemCard {
	
	private boolean isLost = false;

	public AmuletOfAges(Locale loc) {
		super("AmuletOfAges", loc);
		
	}

	@Override
	public void whatToDo(Character character) {
		if(!isLost){
			character.incrementKnowledge();
			character.incrementMight();
			character.incrementSpeed();
			character.incrementSanity();
		}else{
			character.decrementKnowledge(3);
			character.decrementSanity(3);
			character.decrementSpeed(3);
			character.decrementMight(3);
			
		}
	}

}
