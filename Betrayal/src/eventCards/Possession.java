package eventCards;

import java.util.Locale;

import characters.Trait;
import characters.ExplorerType;
import characters.Character;
import characters.HumanStats;
import Game.Game;

public class Possession extends EventCard {

	public Possession(Locale loc) {
		super("Possession", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		HumanStats currentExplorer = (HumanStats) Game.getInstance().getCurrentCharacter().getStats();
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
		Character character = Game.getInstance().getCurrentCharacter();
		HumanStats currentExplorer = (HumanStats) character.getStats();
		
		Trait chosenTrait = Game.getInstance().chooseATrait();
		int rollResult = character.getTraitRoll(chosenTrait);
		if(rollResult >= 4){
			Trait trait1 = Game.getInstance().chooseATrait();
			character.incrementTrait(trait1, 1);
		} else if(rollResult >= 0 && rollResult <=3){
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
