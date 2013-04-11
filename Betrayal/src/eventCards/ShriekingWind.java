package eventCards;

import Game.Game;

public class ShriekingWind extends EventCard {

	private Game game;
	
	public ShriekingWind(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		// TODO: Change this so it affects all players in the Gardens, Graveyard, Patio, Tower, Balcony, or room with an outside-facing window
		if ((rollResult >= 3) && (rollResult <= 4)){
			game.getCurrentCharacter().decrementSpeed(); // TODO: Change this to decrementPhysical when implemented
		} else if((rollResult > 0) && (rollResult < 3)){
			game.getCurrentCharacter().decrementKnowledge(); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			game.getCurrentCharacter().decrementMight(); // TODO: Change this to decrementPhysical
			game.getCurrentCharacter().removeItemCard(game.getCurrentCharacter().getItemHand().get(0)); // TODO: Change this so the player can choose the item card
		}
	}

	@Override
	public void happens() {
		int rollResult = game.rollDice(game.getCurrentCharacter().getCurrentMight());
		// TODO: Change this so it affects all players in the Gardens, Graveyard, Patio, Tower, Balcony, or room with an outside-facing window
		if ((rollResult >= 3) && (rollResult <= 4)){
			game.getCurrentCharacter().decrementSpeed(game.rollDice(1)); // TODO: Change this to decrementPhysical when implemented
		} else if((rollResult > 0) && (rollResult < 3)){
			game.getCurrentCharacter().decrementKnowledge(game.rollDice(1)); // TODO: Change this to decrementMental when implemented
		} else if (rollResult == 0){
			game.getCurrentCharacter().decrementMight(game.rollDice(1)); // TODO: Change this to decrementPhysical
			game.getCurrentCharacter().removeItemCard(game.getCurrentCharacter().getItemHand().get(0)); // TODO: Change this so the player can choose the item card
			// TODO: make it so the item removed is placed in the entrance hall
		}
	}

}
