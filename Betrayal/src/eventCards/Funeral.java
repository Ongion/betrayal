package eventCards;

import Game.Game;

public class Funeral extends EventCard {
	// This is only for testing purposes and will be removed
		private Game game;
		
		public Funeral(String name, String description, Game game) {
			super(name, description);
			this.game = game;
		}

		@Override
		public void happen(int rollResult) {
			// For testing purposes only
			if (rollResult >= 4){
				game.getCurrentPlayer().getCharacter().incrementSanity();
			} else if (rollResult >= 2 && rollResult <= 3){
				game.getCurrentPlayer().getCharacter().decrementSanity();
			} else{
				game.getCurrentPlayer().getCharacter().decrementSanity();
				game.getCurrentPlayer().getCharacter().decrementMight();
			}
		}

		@Override
		public void happens() {
			int rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentSanity());
			if (rollResult >= 4){
				game.getCurrentPlayer().getCharacter().incrementSanity();
			} else if ((rollResult >= 2) && (rollResult <= 3)){
				game.getCurrentPlayer().getCharacter().decrementSanity();
			} else{
				game.getCurrentPlayer().getCharacter().decrementSanity();
				game.getCurrentPlayer().getCharacter().decrementMight();
			}
		}

}
