package eventCards;

import characters.Explorer.Trait;
import Game.Game;

public class Possession extends EventCard {

	private Game game;
	
	public Possession(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementKnowledge(); // TODO: Change this to allow user to choose trait
		} else if(rollResult >= 0 && rollResult <=3){ // TODO: Change this so it decrements the trait they chose first
			boolean decremented = false;
			for (Trait trait : Trait.values()) {
				if(decremented){
					break;
				}
				switch(trait){
				case KNOWLEDGE: 
					if(game.getCurrentCharacter().getCurrentKnowledgeIndex() != 0){
						game.getCurrentCharacter().decrementKnowledge(game.getCurrentCharacter().getCurrentKnowledgeIndex());
						decremented = true;
					}
					break;
				case SANITY: 
					if(game.getCurrentCharacter().getCurrentSanityIndex() != 0){
						game.getCurrentCharacter().decrementSanity(game.getCurrentCharacter().getCurrentSanityIndex());
						decremented = true;
					}
					break;
				case MIGHT: 
					if(game.getCurrentCharacter().getCurrentMightIndex() != 0){
						game.getCurrentCharacter().decrementMight(game.getCurrentCharacter().getCurrentMightIndex());
						decremented = true;
					}
					break;
				case SPEED: 
					if(game.getCurrentCharacter().getCurrentSpeedIndex() != 0){
						game.getCurrentCharacter().decrementSpeed(game.getCurrentCharacter().getCurrentSpeedIndex());
						decremented = true;
					}
					break;
				}
			}
		}

	}

	@Override
	public void happens() {
		int rollResult = game.typeRoll(Trait.KNOWLEDGE); // TODO: Change this to allow user to chose
		if(rollResult >= 4){
			game.getCurrentCharacter().incrementKnowledge(); // TODO: Change this to allow user to choose trait
		} else if(rollResult >= 0 && rollResult <=3){ // TODO: Change this so it decrements the trait they chose first
			boolean decremented = false;
			for (Trait trait : Trait.values()) {
				if(decremented){
					break;
				}
				switch(trait){
				case KNOWLEDGE: 
					if(game.getCurrentCharacter().getCurrentKnowledgeIndex() != 0){
						game.getCurrentCharacter().decrementKnowledge(game.getCurrentCharacter().getCurrentKnowledgeIndex());
						decremented = true;
					}
					break;
				case SANITY: 
					if(game.getCurrentCharacter().getCurrentSanityIndex() != 0){
						game.getCurrentCharacter().decrementSanity(game.getCurrentCharacter().getCurrentSanityIndex());
						decremented = true;
					}
					break;
				case MIGHT: 
					if(game.getCurrentCharacter().getCurrentMightIndex() != 0){
						game.getCurrentCharacter().decrementMight(game.getCurrentCharacter().getCurrentMightIndex());
						decremented = true;
					}
					break;
				case SPEED: 
					if(game.getCurrentCharacter().getCurrentSpeedIndex() != 0){
						game.getCurrentCharacter().decrementSpeed(game.getCurrentCharacter().getCurrentSpeedIndex());
						decremented = true;
					}
					break;
				}
			}
		}

	}

}
