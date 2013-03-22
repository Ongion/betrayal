package eventCards;

import Game.Game;
import characters.Character;

public class Funeral extends EventCard {
	// This is only for testing purposes and will be removed
		private Character character;
		private Game game;
		
		public Funeral(String name, String description, Character person, Game game) {
			super(name, description);
			this.character = person;
			this.game = game;
		}

		@Override
		public void happen(int rollResult) {
			// For testing purposes only
			if (rollResult >= 4){
				character.incrementSanity();
			} else if (rollResult >= 2 && rollResult <= 3){
				character.decrementSanity();
			} else{
				character.decrementSanity();
				character.decrementMight();
			}
		}
			
		@Override
		public Character getCharacter(){
			return character;
		}

		@Override
		public void happens() {
			int rollResult = game.rollDie(character.getCurrentSanity());
			if (rollResult >= 4){
				character.incrementSanity();
			} else if ((rollResult >= 2) && (rollResult <= 3)){
				character.decrementSanity();
			} else{
				character.decrementSanity();
				character.decrementMight();
			}
		}

}
