package eventCards;

import characters.Character;

public class CreepyCrawlies extends EventCard {
	// This is only for testing purposes and will be removed
		private Character character;
		
		public CreepyCrawlies(String name, String description, Character person) {
			super(name, description);
			this.character = person;
		}

		@Override
		public void happen(int rollResult) {
			// rollResult will be removed. It is only for testing purposes
			if (rollResult >= 5){
				character.incrementKnowledge(); // TODO: Change this to incrementSanity when implemented
			} else if ((rollResult >= 1) && (rollResult <= 4)){
				character.decrementKnowledge(); // TODO: Change this to decrementSanity when implemented
			} else{
				character.decrementKnowledge(); // TODO: Change this to decrementSanity
				character.decrementKnowledge(); // TODO: Change this to decrementSanity
			}
		}
		
		@Override
		public Character getCharacter(){
			return character;
		}

}
