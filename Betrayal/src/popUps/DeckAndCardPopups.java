package popUps;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Game.Game;

public class DeckAndCardPopups extends JFrame implements ActionListener {
	
	private int width;
	private int height;
	private Game game;
	
	public DeckAndCardPopups(int windowWidth, int windowHeight) {
		this.width = windowWidth;
		this.height = windowHeight;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //make it close when it's closed.
		this.game = Game.getInstance();
	}

	public DeckAndCardPopups() {
		
	}
	
	public void displayChooseDeckPopup(){
		JFrame deckPopup = new JFrame();
		deckPopup.setTitle("Choose Deck");
		deckPopup.setSize(300, 300);
		
		JButton btnRoom = new JButton("Room");
		btnRoom.setSize(200, 50);
		JButton btnEvent = new JButton("Event");
		btnEvent.setSize(200, 50);
		JButton btnItem = new JButton("Item");
		btnItem.setSize(200, 50);
		JButton btnOmen = new JButton("Omen");
		btnOmen.setSize(200, 50);
		
		btnRoom.setActionCommand("room");
		btnEvent.setActionCommand("event");
		btnItem.setActionCommand("item");
		btnOmen.setActionCommand("omen");
		
		btnRoom.addActionListener(this);
		btnEvent.addActionListener(this);
		btnItem.addActionListener(this);
		btnOmen.addActionListener(this);
		
		Container content = deckPopup.getContentPane();
		content.setLayout(new FlowLayout());
		content.add(btnRoom);
		content.add(btnEvent);
		content.add(btnItem);
		content.add(btnOmen);
		
		deckPopup.setVisible(true);
	}
	
	public void displayRoomDeck(){
		JFrame deckPopup = new JFrame();
		deckPopup.setTitle("Rooms");
		deckPopup.setSize(300, 300);
		
		deckPopup.setVisible(true);
	}
	
	public void displayEventDeck(){
		JFrame deckPopup = new JFrame();
		deckPopup.setTitle("Event Cards");
		deckPopup.setSize(300, 300);
		
		deckPopup.setVisible(true);
	}
	
	public void displayItemDeck(){
		JFrame deckPopup = new JFrame();
		deckPopup.setTitle("Items");
		deckPopup.setSize(300, 300);
		
		deckPopup.setVisible(true);
	}
	
	public void displayOmenDeck(){
		JFrame deckPopup = new JFrame();
		deckPopup.setTitle("Omen");
		deckPopup.setSize(300, 300);
		
		deckPopup.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("room".equals(e.getActionCommand())){
			(new DeckAndCardPopups()).displayRoomDeck();
		} else if ("event".equals(e.getActionCommand())){
			(new DeckAndCardPopups()).displayEventDeck();
		} else if  ("item".equals(e.getActionCommand())){
			(new DeckAndCardPopups()).displayItemDeck();
		} else if ("omen".equals(e.getActionCommand())){
			(new DeckAndCardPopups()).displayOmenDeck();
		}
	}

}
