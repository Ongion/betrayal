package tiles;

import characters.Character;

public interface ITraitRollModifyingTile {
	public String getName();
	public String getDescription();
	public int getModifierForCharacter(Character characterMakingRoll);
}
