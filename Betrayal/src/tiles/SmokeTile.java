package tiles;

import characters.Character;

public class SmokeTile implements ITraitRollModifyingTile {

	public SmokeTile() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getModifierForCharacter(Character characterMakingRoll) {
		return characterMakingRoll.isAffectedBySmoke() ? -2 : 0;
	}

}
