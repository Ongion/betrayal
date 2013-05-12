package eventCards;

import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.Locale;

import characters.Character;
import characters.Trait;
import Game.Game;

public class Debris extends EventCard {
	
	private int attempts = 0;
	private Character characterHolding;
	
	public Debris(Locale loc) {
		super("Debris", loc);
	}

	@Override
	public void happen(int rollResult) {
		// For testing purposes only
		if (rollResult >= 3 ){
			Game.getInstance().getCurrentCharacter().incrementSpeed();
		} else if (rollResult < 3 && rollResult > 0){
			Game.getInstance().getCurrentCharacter().decrementMight(); // TODO: Change this to decrement physical damage
		} else {
			Game.getInstance().getCurrentCharacter().decrementMight(2); // TODO: Change this to decrement physical damage
			Game.getInstance().getCurrentCharacter().addEventCard(this);
		}
	}

	@Override
	public void happens() {
		Character character = Game.getInstance().getCurrentCharacter();
		int rollResult = character.getTraitRoll(Trait.SPEED);
		if (rollResult >= 3 ){
			character.incrementSpeed();
		} else if (rollResult < 3 && rollResult > 0){
			Trait chosenTrait = Game.getInstance().chooseAPhysicalTrait();
			int damage = Game.getInstance().rollDice(1);
			character.decrementTrait(chosenTrait, damage);
		} else {
			Trait chosenTrait = Game.getInstance().chooseAPhysicalTrait();
			int damage = Game.getInstance().rollDice(2);
			character.decrementTrait(chosenTrait, damage);
			character.addEventCard(this);
			characterHolding = character;
		}
	}
	
	@Override
	public void beginningOfTurn(){
		if (attempts <= 3){
			Character character = Game.getInstance().getCurrentCharacter();
			int rollResult = character.getTraitRoll(Trait.MIGHT);
			if(rollResult >= 4){
				//this.characterHolding.removeItemCard(this);
			}else{
				attempts++;
			}
		}else{
			//this.characterHolding.removeItemCard(this); TODO: Figure out how to do this.
		}
	}

}
