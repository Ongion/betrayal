package actions;

import characters.Character;

public abstract class Action {
	
	public abstract String getName();
	
	public abstract String getDescription();
	
	public abstract boolean canPerform(Character characterAttemptingAction);
	
	public abstract void perform(Character characterPerformingAction);
	
	public String toString() {
		return this.getName();
	}

}
