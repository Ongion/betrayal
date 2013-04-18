package characters;

public interface ICharacterType {
	public int getCurrentSanity();
	public int getCurrentKnowlege();
	public int getCurrentMight();
	public int getCurrentSpeead();
	
	public void incrementKnowlege(int amount);
	public void incrementSanity(int amount);
	public void incrementMight(int amount);
	public void incrementSpeed(int amount);
	
	public void decrementSanity(int amount);
	public void decrementKnowledge(int amount);
	public void decrementMight(int amount);
	public void decrementSpeed(int amount);

}
