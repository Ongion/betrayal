package cardGUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import eventCards.EventCard;

public class EventCardFrame extends JFrame {

	/**
	 * Ya I really don't know what this is for but Eclipse always wants it.
	 */
	private static final long serialVersionUID = -300674110989890700L;
	
	private EventCard card;
	
	public EventCardFrame(EventCard card) {
		this(350,500,card);
	}
	
	public EventCardFrame(int width, int height, EventCard card){
		this.card = card;
		
		this.setSize(width, height);
		this.setTitle("Event Card - " + card.getName());
		
		GridLayout gridLayout = new GridLayout(1,3);
		this.setLayout(gridLayout);
		
		//Add the title to the Frame
		JLabel title = new JLabel(card.getName());
		this.add(title);
		
		//Add the description
		JLabel description = new JLabel(card.getDescription());
		this.add(description);
				
		//Add the rules
		JLabel rules = new JLabel(card.getRules());
		this.add(rules);
	}
	
	public void display(){
		this.setVisible(true);
		this.repaint();
	}
	
	public void hide(){
		this.setVisible(false);
		this.repaint();
	}


}
