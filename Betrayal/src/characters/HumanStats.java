package characters;

public class HumanStats implements IStats {
	private String[] hobbies;
	private int height; // In Inches
	private int age;
	private int weight; // In pounds

	private int[] knowledge;
	private int[] sanity;
	private int[] might;
	private int[] speed;
	
	private int knowledgeIndex;
	private int sanityIndex;
	private int mightIndex;
	private int speedIndex;
	
	private final int defaultKnowledge;
	private final int defaultSanity;
	private final int defaultMight;
	private final int defaultSpeed;
	
	public HumanStats(int height, int age, int weight, int[] knowledge, int[] sanity, int[] might, int[] speed, int defaultKnowledge, int defaultSanity, int defaultMight, int defaultSpeed) {
		this.height = height;
		this.age = age;
		this.weight = weight;
		this.knowledge = knowledge;
		this.sanity = sanity;
		this.might = might;
		this.speed = speed;
		this.knowledgeIndex = defaultKnowledge;
		this.sanityIndex = defaultSanity;
		this.mightIndex = defaultMight;
		this.speedIndex = defaultSpeed;
		this.defaultKnowledge = defaultKnowledge;
		this.defaultSanity = defaultSanity;
		this.defaultMight = defaultMight;
		this.defaultSpeed = defaultSpeed;
	}
	
	public String[] getHobbies() {
		return this.hobbies;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getWeight() {
		return this.weight;
	}
	/* Get Attributes and Attribute Indexes */

	public int getCurrentKnowledge() {
		return this.knowledge[this.knowledgeIndex];
	}

	public int getCurrentSanity() {
		return this.sanity[this.sanityIndex];
	}

	public int getCurrentSpeed() {
		return this.speed[this.speedIndex];
	}

	public int getCurrentMight() {
		return this.might[this.mightIndex];
	}

	public int getCurrentKnowledgeIndex() {
		return this.knowledgeIndex;
	}

	public int getCurrentSanityIndex() {
		return this.sanityIndex;
	}

	public int getCurrentSpeedIndex() {
		return this.speedIndex;
	}

	public int getCurrentMightIndex() {
		return this.mightIndex;
	}

	/*
	 * Increase or Decrease the stat by the number specified, then check to make
	 * sure you didn't go up or down passed the edge of the stat array.
	 */
	public void incrementKnowledge(int numToIncreaseBy) {
		this.knowledgeIndex += numToIncreaseBy;

		if (this.knowledgeIndex > 7) {
			this.knowledgeIndex = 7;
		}
	}

	public void decrementKnowledge(int numToDecreaseBy) {
		this.knowledgeIndex -= numToDecreaseBy;

		if (this.knowledgeIndex < 0) {
			this.knowledgeIndex = 0;
		}
	}

	public void incrementSanity(int numToIncreaseBy) {
		this.sanityIndex += numToIncreaseBy;

		if (this.sanityIndex > 7) {
			this.sanityIndex = 7;
		}
	}

	public void decrementSanity(int numToDecreaseBy) {
		this.sanityIndex -= numToDecreaseBy;

		if (this.sanityIndex < 0) {
			this.sanityIndex = 0;
		}
	}

	public void incrementSpeed(int numToIncreaseBy) {
		this.speedIndex += numToIncreaseBy;

		if (this.speedIndex > 7) {
			this.speedIndex = 7;
		}
	}

	public void decrementSpeed(int numToDecreaseBy) {
		this.speedIndex -= numToDecreaseBy;

		if (this.speedIndex < 0) {
			this.speedIndex = 0;
		}
	}

	public void incrementMight(int numToIncreaseBy) {
		this.mightIndex += numToIncreaseBy;

		if (this.mightIndex > 7) {
			this.mightIndex = 7;
		}
	}

	public void decrementMight(int numToDecreaseBy) {
		this.mightIndex -= numToDecreaseBy;

		if (this.mightIndex < 0) {
			this.mightIndex = 0;
		}
	}
	
	public int getDefaultSanity() {
		return this.defaultSanity;
	}
	
	public int getDefaultKnowledge() {
		return this.defaultKnowledge;
	}
	
	public int getDefaultMight() {
		return this.defaultMight;
	}
	
	public int getDefaultSpeed() {
		return this.defaultSpeed;
	}
	
}
