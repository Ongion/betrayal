package rooms;

import java.util.Set;

import Game.Game;
import characters.ExplorerType;
import characters.Character;

public class AtticRoom extends OmenRoom {

	public AtticRoom(String name, Set<Relative_Direction> doorExits, Set<Floor_Name> floorsAllowedOn) {
		super(name, doorExits, floorsAllowedOn);
	}
	
	@Override
	public void leaveRoomInAbsoluteDirection(Character characterLeavingRoom, Relative_Direction exitAttemptingToLeaveBy) {
		/* 
		 * When exiting, you must attempt a Speed roll of 3+.
		 * If you fail, you lose 1 Might (but continue moving) 
		 */
		
		if (!characterLeavingRoom.getSideOfRoom().equals(exitAttemptingToLeaveBy)) {
			int diceToRoll = characterLeavingRoom.getCurrentSpeed();
			int TARGET_RESULT = 3;
			int rollResult = Game.getInstance().rollDice(diceToRoll);
			System.out.println(String.format("Rolled %d dice and got a %d", diceToRoll, rollResult));
			if (rollResult < TARGET_RESULT) {
				characterLeavingRoom.decrementMight(1);
				System.out.println(String.format("%s lost 1 Might!", characterLeavingRoom.getName()));
			} else {
				System.out.println(String.format("%s avoided danger.", characterLeavingRoom.getName()));
			}
		}
	}

}
