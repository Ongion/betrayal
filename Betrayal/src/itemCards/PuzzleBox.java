package itemCards;

import java.util.Locale;

import Game.Game;

import characters.Character;

public class PuzzleBox extends ItemCard {

	public PuzzleBox(Locale loc) {
		super("PuzzleBox", loc);
		
	}

	@Override
	public
	void whatToDo(Character character) {
		character.getItemHand().add(this);
		Game currentGame = Game.getInstance();
		
		int rollResult = currentGame.rollDice(character.getCurrentKnowledge());
		if(rollResult >= 6){
			ItemCard firstCardDrawn = currentGame.drawItem();
			ItemCard secondCardDrawn = currentGame.drawItem();
			character.getItemHand().add(firstCardDrawn);
			character.getItemHand().add(secondCardDrawn);
			character.getItemHand().remove(this);
		}
		else{
			return;
		}
	}

}
