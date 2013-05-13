package cardGUI;

import itemCards.ItemCard;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ItemCardPicker extends JFrame implements ActionListener {

	ArrayList<ItemCard> cards;
	JButton displayButton;
	JComboBox<ItemCard> cardOptions;
	
	public ItemCardPicker(ArrayList<ItemCard> cards){
		this.setSize(200, 100);
		
		GridLayout layout = new GridLayout(2,0);
		this.setLayout(layout);
		
		this.cards = cards;
		
		cardOptions = new JComboBox<ItemCard>();
		
		for (ItemCard item : cards){
			cardOptions.addItem(item);
		}
		cardOptions.setEditable(false);
		
		displayButton = new JButton("Display Item Card");
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
			ItemCardFrame itemFrame = new ItemCardFrame((ItemCard)this.cardOptions.getSelectedItem());
			itemFrame.display();
		}
		
	}
}
