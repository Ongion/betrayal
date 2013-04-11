package rooms;

import java.util.Map;
import java.util.Set;

import Game.Game;
import characters.Character;

public class GraveyardRoom extends OmenRoom {

	public GraveyardRoom(String name, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, doorExits, floorsAllowedOn);
	}
	
	@Override
	public void leavingRoom(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
		/* 
		 * When exiting, you must attempt a Sanity roll of 4+.
		 * If you fail, you lose 1 Knowledge (but continue moving) 
		 */
		
		if (!characterLeavingRoom.getSideOfRoom().equals(exitAttemptingToLeaveBy)) {
			int diceToRoll = characterLeavingRoom.getCurrentSanity();
			int TARGET_RESULT = 3;
			int rollResult = Game.getInstance().rollDice(diceToRoll);
			System.out.println(String.format("Rolled %d dice and got a %d", diceToRoll, rollResult));
			if (Game.getInstance().rollDice(diceToRoll) < TARGET_RESULT) {
				characterLeavingRoom.decrementKnowledge(1);
				System.out.println(String.format("%s lost 1 Knowledge!", characterLeavingRoom.getName()));
			} else {
				System.out.println(String.format("%s avoided danger.", characterLeavingRoom.getName()));
			}
		}
	}

}
