package tiles;

import characters.Character;

public class DripTile implements ITraitRollModifyingTile {

	public DripTile() {
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
		return characterMakingRoll.isAffectedByDrip()? -1 : 0;
	}

}
