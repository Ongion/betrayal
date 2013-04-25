package characters;

import characters.Character;

public class MonsterStats implements IStats {
	private int sanity;
	private int knowledge;
	private int might;
	private int speed;
	
	public MonsterStats() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCurrentSanity() {
		return this.sanity;
	}

	@Override
	public int getCurrentKnowledge() {
		return this.knowledge;
	}

	@Override
	public int getCurrentMight() {
		return this.might;
	}

	@Override
	public int getCurrentSpeed() {
		return this.speed;
	}

	@Override
	public void incrementKnowledge(int amount) {
		// Monster stats don't change.
	}

	@Override
	public void incrementSanity(int amount) {
		// Monster stats don't change.		
	}

	@Override
	public void incrementMight(int amount) {
		// Monster stats don't change.		
	}

	@Override
	public void incrementSpeed(int amount) {
		// Monster stats don't change.		
	}

	@Override
	public void decrementSanity(int amount) {
		// Monster stats don't change.		
	}

	@Override
	public void decrementKnowledge(int amount) {
		// Monster stats don't change.		
	}

	@Override
	public void decrementMight(int amount) {
		// Monster stats don't change.		
	}

	@Override
	public void decrementSpeed(int amount) {
		// Monster stats don't change.		
	}

	@Override
	public int getAge() {
		// Monsters don't have age.
		return -1;
	}

	@Override
	public int getHeight() {
		// Monsters don't have height.
		return -1;
	}

	@Override
	public int getWeight() {
		// Monsters don't have weight.
		return -1;
	}

	@Override
	public String[] getHobbies() {
		// Monsters don't have hobbies.
		return new String[0];
	}

	@Override
	public void setCharacter(Character character) {
		// Monsters don't need this bidirectional connection
	}

}
