package tiles;

import characters.Character;

public class BlessingTile implements ITraitRollModifyingTile {

	public BlessingTile() {}

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
		return characterMakingRoll.isAffectedByBlessing() ? 1 : 0;		
	}

}
