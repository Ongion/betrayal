package popUps;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Game.Game;

import characters.Trait;

public class TraitPopup extends JFrame implements ActionListener {
	
	private int width;
	private int height;
	
	public TraitPopup(int windowWidth, int windowHeight) {
		this.width = windowWidth;
		this.height = windowHeight;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //make it close when it's closed.
	}

	public TraitPopup() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void displayChooseRollTypePopup(){
		//this.removeAll();
		this.setTitle("Choose Trait");
		this.setSize(300, 300);
		
		JButton btnKnowledge = new JButton("Knowledge");
		btnKnowledge.setSize(200, 50);
		JButton btnSanity = new JButton("Sanity");
		btnSanity.setSize(200, 50);
		JButton btnMight = new JButton("Might");
		btnMight.setSize(200, 50);
		JButton btnSpeed = new JButton("Speed");
		btnSpeed.setSize(200, 50);
		
		btnKnowledge.setActionCommand("knowledge");
		btnSanity.setActionCommand("sanity");
		btnMight.setActionCommand("might");
		btnSpeed.setActionCommand("speed");
		
		btnKnowledge.addActionListener(this);
		btnSanity.addActionListener(this);
		btnMight.addActionListener(this);
		btnSpeed.addActionListener(this);
		
		Container content = this.getContentPane();
		content.setLayout(new FlowLayout());
		content.add(btnKnowledge);
		content.add(btnSanity);
		content.add(btnMight);
		content.add(btnSpeed);
		
		this.setVisible(true);
	}
	
	public void displayChoosePhysicalPopup(){
		this.removeAll();
		JFrame physicalPopup = new JFrame();
		physicalPopup.setTitle("Choose Physical Trait");
		physicalPopup.setSize(300, 300);
		
		JButton btnMight = new JButton("Might");
		btnMight.setSize(200, 50);
		JButton btnSpeed = new JButton("Speed");
		btnSpeed.setSize(200, 50);
		
		btnMight.setActionCommand("might");
		btnSpeed.setActionCommand("speed");
		
		btnMight.addActionListener(this);
		btnSpeed.addActionListener(this);
		
		Container content = physicalPopup.getContentPane();
		content.setLayout(new FlowLayout());
		content.add(btnMight);
		content.add(btnSpeed);
		
		physicalPopup.setVisible(true);
	}
	
	public void displayChooseMentalPopup(){
		this.removeAll();
		JFrame mentalPopup = new JFrame();
		mentalPopup.setTitle("Choose Mental Trait");
		mentalPopup.setSize(300, 300);
		
		JButton btnKnowledge = new JButton("Knowledge");
		btnKnowledge.setSize(200, 50);
		JButton btnSanity = new JButton("Sanity");
		btnSanity.setSize(200, 50);
		
		btnKnowledge.setActionCommand("knowledge");
		btnSanity.setActionCommand("sanity");
		
		btnKnowledge.addActionListener(this);
		btnSanity.addActionListener(this);
		
		Container content = mentalPopup.getContentPane();
		content.setLayout(new FlowLayout());
		content.add(btnKnowledge);
		content.add(btnSanity);
		
		mentalPopup.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("knowledge".equals(e.getActionCommand())){
			Game.getInstance().setTraitForAction(Trait.KNOWLEDGE);
			TraitPopup.this.dispose();
			TraitPopup.this.setVisible(false);
		} else if ("sanity".equals(e.getActionCommand())){
			Game.getInstance().setTraitForAction(Trait.SANITY);
			this.dispose();
		} else if  ("might".equals(e.getActionCommand())){
			Game.getInstance().setTraitForAction(Trait.MIGHT);
			this.dispose();
		} else if ("speed".equals(e.getActionCommand())){
			Game.getInstance().setTraitForAction(Trait.SPEED);
			this.dispose();
		}
	}

}
