package eventCards;

import itemCards.ItemCard;
import itemCards.PuzzleBox;

import java.util.ArrayList;
import java.util.Locale;

import Game.Game;
import characters.Character;

public class JonahsTurn extends EventCard {

	private Game game;
	
	public JonahsTurn(Locale loc){
		super("JonahsTurn", loc);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void happens() {
		Character exp1 = null;
		int index = 0;
		ArrayList<Character> players = game.getCharacters();
		search: for (int i = 0; i < players.size(); i++){
			if(players.get(i).getItemHand().size() > 0){
				ArrayList<ItemCard> items = players.get(i).getItemHand();
				for (int j = 0; j < items.size(); j++){
					if(items.get(j).getName() == (new PuzzleBox(game.getLocale())).getName()){
						exp1 = players.get(i);
						index = j;
						break search;
					}
				}
			}
		}
		if (exp1 != null){
			exp1.removeItemCard(exp1.getItemHand().get(index));
			exp1.addItemCard(game.drawItem());
			game.getCurrentCharacter().incrementSanity();
		}
		else
		{
			game.getCurrentCharacter().decrementSanity(game.rollDice(1)); // TODO: Change this to decrementMental
		}

	}

}
