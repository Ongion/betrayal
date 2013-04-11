package rooms;

import java.util.Set;

import Game.Game;

import characters.Character;

public class PentagramChamberRoom extends OmenRoom {

	public PentagramChamberRoom(String name, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, doorExits, floorsAllowedOn);
	}
	
	@Override
	public void leavingRoom(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) { 
		/* 
		 * When exiting, you must attempt a Knowledge roll of 4+
		 * If you fail, lose 1 Sanity (but continue moving). 
		 */
		
		int diceToRoll = characterLeavingRoom.getCurrentKnowledge();
		int TARGET_RESULT = 4;
		int rollResult = Game.getInstance().rollDice(diceToRoll);
		System.out.println(String.format("Rolled %d dice and got a %d", diceToRoll, rollResult));
		if (Game.getInstance().rollDice(diceToRoll) < TARGET_RESULT) {
			characterLeavingRoom.decrementSanity(1);
			System.out.println(String.format("%s lost 1 sanity!", characterLeavingRoom.getName()));
		} else {
			System.out.println(String.format("%s avoided danger!", characterLeavingRoom.getName()));
		}
	}


}
