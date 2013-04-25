package itemCards;

import characters.Explorer;

public class AmuletOfAges extends ItemCard {
	
	private boolean isLost = false;

	public AmuletOfAges(String name, String description) {
		super(name, description);
		
	}

	@Override
	public void whatToDo(Explorer character) {
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
