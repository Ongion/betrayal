package eventCards;

import itemCards.ItemCard;
import itemCards.PuzzleBox;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import Game.Game;
import characters.Character;
import characters.Trait;

public class JonahsTurn extends EventCard {

	public JonahsTurn(Locale loc){
		super("JonahsTurn", loc);
	}
	
	@Override
	public void happen(int rollResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		Character exp1 = null;
		int index = 0;
		ArrayList<Character> players = Game.getInstance().getCharacters();
		search: for (int i = 0; i < players.size(); i++){
			if(players.get(i).getItemHand().size() > 0){
				ArrayList<ItemCard> items = players.get(i).getItemHand();
				ResourceBundle messages = ResourceBundle.getBundle("ItemCardBundle", Game.getInstance().getLocale());
				for (int j = 0; j < items.size(); j++){
					if(items.get(j).getName() == messages.getString("titlePuzzleBox")){
						exp1 = players.get(i);
						index = j;
						break search;
					}
				}
			}
		}
		if (exp1 != null){
			exp1.removeItemCard(exp1.getItemHand().get(index));
			exp1.addItemCard(Game.getInstance().drawItem());
			character.incrementSanity();
		}
		else
		{
			Trait chosenTrait = Game.getInstance().chooseAMentalTrait();
			int damage = Game.getInstance().rollDice(1);
			character.decrementTrait(chosenTrait, damage);
		}

	}

}
