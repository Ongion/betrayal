package eventCards;

import characters.Character.Trait;
import characters.ExplorerType;
import characters.HumanStats;
import Game.Game;

public class Possession extends EventCard {

	private Game game;
	
	public Possession(String name, String description) {
		super(name, description);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		HumanStats currentExplorer = (HumanStats) game.getCurrentCharacter().getStats();
		if(rollResult >= 4){
			currentExplorer.incrementKnowledge(1); // TODO: Change this to allow user to choose trait
		} else if(rollResult >= 0 && rollResult <=3){ // TODO: Change this so it decrements the trait they chose first
			boolean decremented = false;
			for (Trait trait : Trait.values()) {
				if(decremented){
					break;
				}
				switch(trait){
				case KNOWLEDGE: 
					if(currentExplorer.getCurrentKnowledgeIndex() != 0){
						currentExplorer.decrementKnowledge(currentExplorer.getCurrentKnowledgeIndex());
						decremented = true;
					}
					break;
				case SANITY: 
					if(currentExplorer.getCurrentSanityIndex() != 0){
						currentExplorer.decrementSanity(currentExplorer.getCurrentSanityIndex());
						decremented = true;
					}
					break;
				case MIGHT: 
					if(currentExplorer.getCurrentMightIndex() != 0){
						currentExplorer.decrementMight(currentExplorer.getCurrentMightIndex());
						decremented = true;
					}
					break;
				case SPEED: 
					if(currentExplorer.getCurrentSpeedIndex() != 0){
						currentExplorer.decrementSpeed(currentExplorer.getCurrentSpeedIndex());
						decremented = true;
					}
					break;
				}
			}
		}

	}

	@Override
	public void happens() {
		HumanStats currentExplorer = (HumanStats) game.getCurrentCharacter().getStats();
		int rollResult = game.typeRoll(Trait.KNOWLEDGE); // TODO: Change this to allow user to chose
		if(rollResult >= 4){
			currentExplorer.incrementKnowledge(1); // TODO: Change this to allow user to choose trait
		} else if(rollResult >= 0 && rollResult <=3){ // TODO: Change this so it decrements the trait they chose first
			boolean decremented = false;
			for (Trait trait : Trait.values()) {
				if(decremented){
					break;
				}
				switch(trait){
				case KNOWLEDGE: 
					if(currentExplorer.getCurrentKnowledgeIndex() != 0){
						currentExplorer.decrementKnowledge(currentExplorer.getCurrentKnowledgeIndex());
						decremented = true;
					}
					break;
				case SANITY: 
					if(currentExplorer.getCurrentSanityIndex() != 0){
						currentExplorer.decrementSanity(currentExplorer.getCurrentSanityIndex());
						decremented = true;
					}
					break;
				case MIGHT: 
					if(currentExplorer.getCurrentMightIndex() != 0){
						currentExplorer.decrementMight(currentExplorer.getCurrentMightIndex());
						decremented = true;
					}
					break;
				case SPEED: 
					if(currentExplorer.getCurrentSpeedIndex() != 0){
						currentExplorer.decrementSpeed(currentExplorer.getCurrentSpeedIndex());
						decremented = true;
					}
					break;
				}
			}
		}

	}

}
