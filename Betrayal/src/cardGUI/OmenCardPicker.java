package cardGUI;

import omenCards.OmenCard;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class OmenCardPicker extends JFrame implements ActionListener {

	ArrayList<OmenCard> cards;
	JButton displayButton;
	JComboBox<OmenCard> cardOptions;
	
	public OmenCardPicker(ArrayList<OmenCard> cards){
		this.setSize(200, 100);
		
		GridLayout layout = new GridLayout(2,0);
		this.setLayout(layout);
		
		this.cards = cards;
		
		cardOptions = new JComboBox<OmenCard>();
		
		for (OmenCard Omen : cards){
			cardOptions.addItem(Omen);
		}
		cardOptions.setEditable(false);
		
		displayButton = new JButton("Display Omen Card");
		displayButton.addActionListener(this);
		
		this.add(cardOptions);
		this.add(displayButton);
	}

	public void display() {
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.displayButton){
			OmenCardFrame OmenFrame = new OmenCardFrame((OmenCard)this.cardOptions.getSelectedItem());
			OmenFrame.display();
		}
		
	}
}
