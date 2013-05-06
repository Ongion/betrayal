package eventCards;

import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.Locale;

import omenCards.Spear;

import characters.Character;
import characters.Trait;

import Game.Game;

public class CreepyPuppet extends EventCard {

	private Game game;
	
	public CreepyPuppet(Locale loc){
		super("CreepyPuppet", loc);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void happens() {
		Character exp1 = null;
		ArrayList<Character> players = game.getCharacters();
		search: for (int i = 0; i < players.size(); i++){
			if(players.get(i).getItemHand().size() > 0){
				ArrayList<ItemCard> items = players.get(i).getItemHand();
				for (int j = 0; j < items.size(); j++){
					if(items.get(j).getName() == (new Spear(game.getLocale())).getName()){
						exp1 = players.get(i);
						break search;
					}
				}
			}
		}
		
		int opponentRoll = game.rollDice(4);
		int playerRoll = game.typeRoll(Trait.MIGHT);
		boolean hadDamage = false;
		
		if(opponentRoll > playerRoll){
			hadDamage = true;
			game.getCurrentCharacter().decrementMight(opponentRoll - playerRoll); // TODO: change to decrementPhysical
		}
		
		if (hadDamage && exp1 != null && exp1 != game.getCurrentCharacter()){
			exp1.incrementMight(2);
		}

	}

}
