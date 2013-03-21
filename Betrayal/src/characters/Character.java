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
	
	
	
	public Character(int charIndex, Locale l){
		
		ResourceBundle CharacterBundle = null;
		
		switch (charIndex){
			case 0: CharacterBundle = ResourceBundle.getBundle("characters.CharacterBundle_FatherRhinehardt", l); break;
		}
		
		String[] knowledgeString = CharacterBundle.getString("knowledgeArray").split(",");
		String[] sanityString = CharacterBundle.getString("sanityArray").split(",");
		String[] mightString = CharacterBundle.getString("mightArray").split(",");
		String[] speedString = CharacterBundle.getString("speedArray").split(",");
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
		this.knowledgeIndex = Integer.parseInt(CharacterBundle.getString("knowledgeIndex"));
		this.sanityIndex = Integer.parseInt(CharacterBundle.getString("sanityIndex"));
		this.mightIndex = Integer.parseInt(CharacterBundle.getString("mightIndex"));
		this.speedIndex = Integer.parseInt(CharacterBundle.getString("speedIndex"));
		
		this.name = CharacterBundle.getString("name");
		this.height = Integer.parseInt(CharacterBundle.getString("height"));
		this.weight = Integer.parseInt(CharacterBundle.getString("weight"));
		this.age = Integer.parseInt(CharacterBundle.getString("age"));
		this.hobbies = CharacterBundle.getString("hobbies").split(",");
		// Initialize the variables to their localized values
	}
	
	
	/* Basic Getters */
	public String getName() {
		return name;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	public int getAge() {
		return age;
	}

	public String[] getHobbies() {
		return hobbies;
	}
	
	public int getCurrentKnowledge() {
		return this.knowledge[this.knowledgeIndex];
	}
	
	
	
	/* Increase or Decrease the stat by the number specified, then check to make sure you didn't go up or down passed the edge
	 * of the stat array.
	 */
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
	
	
	public void incrementSanity(int numToIncreaseBy){
		this.sanityIndex += numToIncreaseBy;
		
		if (this.sanityIndex > 7) {
			this.sanityIndex = 7;
		}
	}
	
	public void decrementSanity(int numToDecreaseBy){
		this.sanityIndex -= numToDecreaseBy;
		
		if (this.sanityIndex < 0) {
			this.sanityIndex = 0;
		}
	}
	
	
	public void incrementSpeed(int numToIncreaseBy){
		this.speedIndex += numToIncreaseBy;
		
		if (this.speedIndex > 7) {
			this.speedIndex = 7;
		}
	}
	
	public void decrementSpeed(int numToDecreaseBy){
		this.speedIndex -= numToDecreaseBy;
		
		if (this.speedIndex < 0) {
			this.speedIndex = 0;
		}
	}
	
	
	public void incrementMight(int numToIncreaseBy){
		this.mightIndex += numToIncreaseBy;
		
		if (this.mightIndex > 7) {
			this.mightIndex = 7;
		}
	}
	
	public void decrementMight(int numToDecreaseBy){
		this.mightIndex -= numToDecreaseBy;
		
		if (this.mightIndex < 0) {
			this.mightIndex = 0;
		}
	}
	
	
	/* These methods just make it easier to increase or decrease by 1 */ 
	public void incrementKnowledge(){
		this.incrementKnowledge(1);
	}
	public void decrementKnowledge(){
		this.decrementKnowledge(1);
	}
	public void incrementSanity(){
		this.incrementSanity(1);	
	}
	public void decrementSanity(){
		this.decrementSanity(1);
	}
	public void incrementSpeed(){
		this.incrementSpeed(1);
	}
	public void decrementSpeed(){
		this.decrementSpeed(1);
	}
	public void incrementMight(){
		this.incrementMight(1);
	}	
	public void decrementMight(){
		this.decrementMight(1);
	}
	
}
