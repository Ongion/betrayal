package actionGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import actions.Action;

import Game.Game;

public class ActionButton extends JButton {
	

	
	public ActionButton(final Action action) {

		
		this.setText(action.getName());
		this.setToolTipText(action.getDescription());
	
		this.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	action.perform(Game.getInstance().getCurrentCharacter());
	        	
	        	//TODO Ben delete this too
	        	Game.getInstance().updateFrames();
	        }
		});
		
	}
}