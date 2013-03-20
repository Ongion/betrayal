package eventCards;

import characters.Character;

public class NightView extends EventCard {
	// This is only for testing purposes and will be removed
		private Character character;
		
		public NightView(String name, String description, Character person) {
			super(name, description);
			this.character = person;
		}

		@Override
		public void happen(int rollResult) {
			// rollResult will be removed. It is only for testing purposes
			if (rollResult >= 5){
				character.incrementKnowledge(); // TODO: Change this to incrementSanity when implemented
			} 
		}
		
		@Override
		public Character getCharacter(){
			return character;
		}
}
