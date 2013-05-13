package actionGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import actions.Action;
import actions.EndTurnAction;

import Game.Game;

public class ActionPanel extends JPanel {
	
	public ActionPanel() {

		
		this.update();
	}

	
	public void update(){
		this.removeAll();
		
		ArrayList<Action> actions = Game.getInstance().getCurrentCharacter().getPossibleActions();
		
		for (Action a : actions){
			ActionButton actionButton = new ActionButton(a);
			this.add(actionButton);
		}
		
		this.repaint();
	}

}
