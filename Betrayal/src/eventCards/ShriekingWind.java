package eventCards;

import Game.Game;

public class ShriekingWind extends EventCard {

	// This is only for testing purposes and will be removed
	private Game game;
	
	public ShriekingWind(String name, String description, Game game) {
		super(name, description);
		this.game = game;
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		// TODO: Change this so it affects all players in the Gardens, Graveyard, Patio, Tower, Balcony, or room with an outside-facing window
		if ((rollResult >= 3) && (rollResult <= 4)){
			game.getCurrentPlayer().getCharacter().decrementSpeed(); // TODO: Change this to decrementPhysical when implemented
		} else if((rollResult > 0) && (rollResult < 3)){
			game.getCurrentPlayer().getCharacter().decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			game.getCurrentPlayer().getCharacter().decrementMight(); // TODO: Change this to decrementPhysical
			game.getCurrentPlayer().removeItemCard(game.getCurrentPlayer().getItemHand().get(0)); // TODO: Change this so the player can choose the item card
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDie(game.getCurrentPlayer().getCharacter().getCurrentMight());
		// TODO: Change this so it affects all players in the Gardens, Graveyard, Patio, Tower, Balcony, or room with an outside-facing window
		if ((rollResult >= 3) && (rollResult <= 4)){
			game.getCurrentPlayer().getCharacter().decrementSpeed(game.rollDie(1)); // TODO: Change this to decrementPhysical when implemented
		} else if((rollResult > 0) && (rollResult < 3)){
			game.getCurrentPlayer().getCharacter().decrementKnowledge(game.rollDie(1)); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			game.getCurrentPlayer().getCharacter().decrementMight(game.rollDie(1)); // TODO: Change this to decrementPhysical
			game.getCurrentPlayer().removeItemCard(game.getCurrentPlayer().getItemHand().get(0)); // TODO: Change this so the player can choose the item card
			// TODO: make it so the item removed is placed in the entrance hall
		}
	}

}
