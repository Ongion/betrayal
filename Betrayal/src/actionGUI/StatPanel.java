package actionGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Game;
import characters.Character;

public class StatPanel extends JPanel {
	
	private JLabel charName = new JLabel();
	private JLabel charSpeed = new JLabel();
	private JLabel charMight = new JLabel();
	private JLabel charKnowledge = new JLabel();
	private JLabel charSanity = new JLabel();
	
	private JLabel movesLeftPanel = new JLabel();
	
	public StatPanel(){
		GridLayout layout = new GridLayout(0, 1);
		this.setLayout(layout);
		
		this.add(charName);
		this.add(charSpeed);
		this.add(charMight);
		this.add(charKnowledge);
		this.add(charSanity);
		this.add(new JPanel()); //Basically just create an empty space
		this.add(movesLeftPanel);
		
		this.update();
	}
	
	public void update(){
		Character curr = Game.getInstance().getCurrentCharacter();
		this.charName.setText(curr.getName());
		
		ResourceBundle bundle = ResourceBundle.getBundle("actions.ActionBundle", Game.getInstance().getLocale());
		
		this.charKnowledge.setText(bundle.getString("CurrentKnowledge")+ ": " + curr.getCurrentKnowledge());
		this.charSpeed.setText(bundle.getString("CurrentSpeed")+ ": " + curr.getCurrentSpeed());
		this.charSanity.setText(bundle.getString("CurrentSanity")+ ": " + curr.getCurrentSanity());
		this.charMight.setText(bundle.getString("CurrentMight")+ ": " + curr.getCurrentMight());
		
		this.movesLeftPanel.setText(bundle.getString("MovesLeft")+ ": " + curr.getMovesLeft());
		
		this.repaint();
	}

}
