package characters;

public interface IStats {
	public int getCurrentSanity();
	public int getCurrentKnowledge();
	public int getCurrentMight();
	public int getCurrentSpeed();
	
	public void incrementKnowledge(int amount);
	public void incrementSanity(int amount);
	public void incrementMight(int amount);
	public void incrementSpeed(int amount);
	
	public void decrementSanity(int amount);
	public void decrementKnowledge(int amount);
	public void decrementMight(int amount);
	public void decrementSpeed(int amount);
	
	public int getAge();
	public int getHeight();
	public int getWeight();
	
	public String[] getHobbies();
}
