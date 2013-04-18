package omenCards;

import Game.Game;
import characters.Explorer;

public class Mask extends OmenCard {


	

	public boolean isMaskOn;

	public Mask(String name, String quote) {
		super(name, quote);
	}

	@Override
	public Object whatToDo() {
//
//		Character currentCharacter = Game.getInstance().getCurrentCharacter();
//		boolean canUseMask = false;
//		int sanityRollNeeded = this.currentCharacter.getCurrentSanity();
//		int resultOfRoll = this.currentGame.rollDie(sanityRollNeeded);
//
//		if (resultOfRoll >= 4) {
//			canUseMask = true;
//			putOnMask();
//			if (putOnMask() == true) {
//				currentCharacter.incrementKnowledge(2);
//				currentCharacter.decrementSanity(2);
//			} else {
//				currentCharacter.incrementSanity(2);
//				currentCharacter.decrementKnowledge(2);
//			}
//		}
//		if (resultOfRoll >= 0 && resultOfRoll <= 3) {
//			canUseMask = false;
//
//		}

		return 0;
	}

	@Override
	public void whatToDo(Explorer character, Game game) {
		
		game.rollDice(character.getCurrentSanity());
		if(isMaskOn){
			character.incrementKnowledge(2);
			character.decrementSanity(2);
		}
		if(!isMaskOn){
			character.decrementKnowledge(2);
			character.incrementSanity(2);
		}
		
	}

	@Override
	public void isLost(Explorer character) {
		// TODO Auto-generated method stub
		
	}





}
