package actionGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

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
		this.charKnowledge.setText("Current Knowledge: " + curr.getCurrentKnowledge());
		this.charSpeed.setText("Current Speed: " + curr.getCurrentSpeed());
		this.charSanity.setText("Current Sanity: " + curr.getCurrentSanity());
		this.charMight.setText("Current Might: " + curr.getCurrentMight());
		
		this.movesLeftPanel.setText("Moves Left: " + curr.getMovesLeft());
		
		this.repaint();
	}

}
