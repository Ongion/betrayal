package cardGUI;

import eventCards.EventCard;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class EventCardPicker extends JFrame implements ActionListener {

	ArrayList<EventCard> cards;
	JButton displayButton;
	JComboBox<EventCard> cardOptions;
	
	public EventCardPicker(ArrayList<EventCard> cards){
		this.setSize(200, 100);
		
		GridLayout layout = new GridLayout(2,0);
		this.setLayout(layout);
		
		this.cards = cards;
		
		cardOptions = new JComboBox<EventCard>();
		
		for (EventCard Event : cards){
			cardOptions.addItem(Event);
		}
		cardOptions.setEditable(false);
		
		displayButton = new JButton("Display Event Card");
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
			EventCardFrame EventFrame = new EventCardFrame((EventCard)this.cardOptions.getSelectedItem());
			EventFrame.display();
		}
		
	}
}
