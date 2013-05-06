package cardGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import omenCards.OmenCard;

public class OmenCardFrame extends JFrame {

	/**
	 * Ya I really don't know what this is for but Eclipse always wants it.
	 */
	private static final long serialVersionUID = -300674110989890700L;
	
	private OmenCard card;
	
	
	public OmenCardFrame(OmenCard card) {
		this(340,630,card);
		//This default size matches the size of the picture
	}
	
	public OmenCardFrame(int width, int height, OmenCard card){
		this.card = card;
		
		this.setSize(width, height);
		this.setTitle("Event Card - " + card.getName());
		
		JPanel panel = null;
		try {
			panel = new BackgroundPanel(ImageIO.read(new File("Betrayal/images/FrontOfOmenCard.jpg")));
		} catch (Exception e){
			panel = new JPanel();
			System.out.println("File most likely not found. Reverting to JPanel, instead of BackgroundPanel");
			System.out.println(e);
		}
		
		//GridLayout gridLayout = new GridLayout(0,1);//Zero so it auto sizes the Grid Based on what's in it
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		
		//Add the title to the Frame
		JLabel title = new JLabel("<html><p>"+card.getName()+"</p></html>");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(BorderFactory.createEmptyBorder(50,0,20,0));
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		panel.add(title);
		
		//Add the description
		JLabel description = new JLabel("<html><p>"+card.getDescription()+"</p></html>");
		description.setHorizontalAlignment(SwingConstants.CENTER);
		description.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
		panel.add(description);
				
		//Add the rules
		JLabel rules = new JLabel("<html><p>"+card.getRules()+"</p></html>");
		//Using HTML in JLabel's is weird but kinda awesome, for a web developer at least.
		//Using the HTML to autowrap the text inside the JLabel
		rules.setHorizontalAlignment(SwingConstants.CENTER);
		rules.setBorder(BorderFactory.createEmptyBorder(30,0,50,0));
		panel.add(rules);
		
		this.setContentPane(panel);
		
	}
	
	public void display(){
		this.setVisible(true);
		this.repaint();
	}
	
 
}
