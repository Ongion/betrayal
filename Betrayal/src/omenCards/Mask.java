package omenCards;

import Game.Game;
import characters.ExplorerType;

public class Mask extends OmenCard {


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
	public void whatToDo(ExplorerType character, Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isLost(ExplorerType character) {
		// TODO Auto-generated method stub
		
	}

//	public boolean putOnMask() {
//
//		return true;
//
//	}

}
