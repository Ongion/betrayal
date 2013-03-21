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
		
		switch (charIndex){
			case 0: this.CharacterBundle = ResourceBundle.getBundle("characters.CharacterBundle_FatherRhinehardt", l); break;
		}
		
		String[] knowledgeString = this.CharacterBundle.getString("knowledgeArray").split(",");
		String[] sanityString = this.CharacterBundle.getString("sanityArray").split(",");
		String[] mightString = this.CharacterBundle.getString("mightArray").split(",");
		String[] speedString = this.CharacterBundle.getString("speedArray").split(",");
		//String containing the values for the different arrays
		
		this.knowledge = new int[knowledgeString.length];
		for (int i = 0; i < knowledge.length; i++){
			this.knowledge[i] = Integer.parseInt(knowledgeString[i]);
		}
		this.sanity = new int[sanityString.length];
		for (int i = 0; i < sanity.length; i++){
			this.sanity[i] = Integer.parseInt(sanityString[i]);
		}
		this.speed = new int[speedString.length];
		for (int i = 0; i < speed.length; i++){
			this.speed[i] = Integer.parseInt(speedString[i]);
		}
		this.might = new int[mightString.length];
		for (int i = 0; i < might.length; i++){
			this.might[i] = Integer.parseInt(mightString[i]);
		}
		//Convert the string values to ints
		
		this.knowledgeIndex = Integer.parseInt(this.CharacterBundle.getString("knowledgeIndex"));
		this.sanityIndex = Integer.parseInt(this.CharacterBundle.getString("sanityIndex"));
		this.mightIndex = Integer.parseInt(this.CharacterBundle.getString("mightIndex"));
		this.speedIndex = Integer.parseInt(this.CharacterBundle.getString("speedIndex"));
	}
	
	public String getName() {
		return this.CharacterBundle.getString("name");
	}
	
	public int getHeight() {
		return Integer.parseInt(this.CharacterBundle.getString("height"));
	}
	public int getWeight() {
		return Integer.parseInt(this.CharacterBundle.getString("weight"));
	}
	public int getAge() {
		return Integer.parseInt(this.CharacterBundle.getString("age"));
	}

	public String[] getHobbies() {
		return this.CharacterBundle.getString("hobbies").split(",");
	}
	
	public int getCurrentKnowledge() {
		return this.knowledge[this.knowledgeIndex];
	}
	
	public void incrementKnowledge(){
		this.incrementKnowledge(1);
		
	}
	
	public void decrementKnowledge(){
		this.decrementKnowledge(1);
	}
	
	public void incrementKnowledge(int numToIncreaseBy){
		this.knowledgeIndex += numToIncreaseBy;
		
		if (this.knowledgeIndex > 7) {
			this.knowledgeIndex = 7;
		}
	}
	
	public void decrementKnowledge(int numToDecreaseBy){
		this.knowledgeIndex -= numToDecreaseBy;
		
		if (this.knowledgeIndex < 0) {
			this.knowledgeIndex = 0;
		}
	}
	
}
