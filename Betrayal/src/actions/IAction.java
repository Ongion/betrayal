package actions;

import characters.Character;

public interface IAction {
	
	public String getName();
	
	public String getDescription();
	
	public boolean canPerform(Character characterAttemptingAction);
	
	public void perform(Character characterPerformingAction);

}
