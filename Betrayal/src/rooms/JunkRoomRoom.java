package rooms;

import java.util.Set;

import Game.Game;

import characters.Explorer;

public class JunkRoomRoom extends OmenRoom {

	public JunkRoomRoom(String name, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, doorExits, floorsAllowedOn);
	}
	
	@Override
	public void leavingRoom(Explorer characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) { 
		/* 
		 * When exiting, you must attempt a Might roll of 3+
		 * If you fail, lose 1 Speed (but continue moving). 
		 */
		
		int diceToRoll = characterLeavingRoom.getCurrentMight();
		int TARGET_RESULT = 3;
		int rollResult = Game.getInstance().rollDice(diceToRoll);
		System.out.println(String.format("Rolled %d dice and got a %d", diceToRoll, rollResult));
		if (rollResult < TARGET_RESULT) {
			characterLeavingRoom.decrementSpeed(1);
			System.out.println(String.format("%s lost 1 speed!", characterLeavingRoom.getName()));
		} else {
			System.out.println(String.format("%s avoided danger.", characterLeavingRoom.getName()));
		}
	}


}