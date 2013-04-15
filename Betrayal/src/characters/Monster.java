package characters;

public class Monster extends Character {

	protected int knowledge;
	protected int sanity;
	protected int might;
	protected int speed;
	
	public enum Monsters { Temp_Monster1 };
	
	public Monster(Monsters m){
		switch (m){
			case Temp_Monster1:
				knowledge = 1;
				sanity = 1;
				might = 1;
				speed = 1;
				break;
		}
	}
	
	public int getCurrentSanity(){
		return this.sanity;
	}
	public int getCurrentKnowledge(){
		return this.knowledge;
	}
	public int getCurrentSpeed(){
		return this.speed;
	}
	public int getCurrentMight(){
		return this.might;
	}
}
