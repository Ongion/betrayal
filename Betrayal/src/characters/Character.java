package characters;

import java.util.Locale;
import java.util.ResourceBundle;



public class Character {

	protected String name;
	protected String[] hobbies;
	protected int height; //In Inches
	protected int age;
	protected int weight; //In pounds
	
	protected int[] knowledge;
	protected int[] sanity;
	protected int[] might;
	protected int[] speed;
	protected int knowledgeIndex;
	protected int sanityIndex;
	protected int mightIndex;
	protected int speedIndex;
	
	private ResourceBundle CharacterBundle;
	
	public Character(int charIndex, Locale l){
		this.CharacterBundle = ResourceBundle.getBundle("CharacterBundle", l);
	}
	
	
	
	public String getName() {
		return this.name;
	}
	public int getHeight() {
		return this.height;
	}
	public int getWeight() {
		return this.weight;
	}
	public int getAge() {
		return this.age;
	}

	public String[] getHobbies() {
		return this.hobbies;
	}
	
	public int getCurrentKnowledge() {
		return this.knowledge[this.knowledgeIndex];
	}
	
	public void incrementKnowledge(){
		if (this.knowledgeIndex + 1 < this.knowledge.length)
			this.knowledgeIndex++;
		
	}
	
	public void decrementKnowledge(){
		if (this.knowledgeIndex > 0)
			this.knowledgeIndex--;
	}
	
}
