package popUps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import characters.Trait;

public class GameFrame extends JFrame implements ActionListener {

	private int width;
	private int height;

	public GameFrame(int windowWidth, int windowHeight) {
		this.width = windowWidth;
		this.height = windowHeight;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // make it close when
															// it's closed.

	}

	public GameFrame() {

	}

	public static void displayMenu() {
		// Make Frame
		JFrame menuFrame = new JFrame("Betrayal at House on the Hill");
		menuFrame.setSize(1000, 1000);

		// Make Buttons
		JButton play = new JButton("Play");
		JButton rules = new JButton("Rules");
		JButton characters = new JButton("Characters");
		JButton background = new JButton("Background");
		JButton exit = new JButton("Exit");
		// Set their bounds
		play.setBounds(50, 250, 100, 50);
		rules.setBounds(50, 350, 100, 50);
		characters.setBounds(50, 450, 100, 50);
		background.setBounds(50, 550, 100, 50);
		exit.setBounds(50, 650, 100, 50);
		// Add button actions
		rules.setActionCommand("rules");
		characters.setActionCommand("characters");
		
		// Add buttons to frame
		menuFrame.add(play);
		menuFrame.add(rules);
		menuFrame.add(characters);
		menuFrame.add(background);
		menuFrame.add(exit);

		// Make image an icon and add to JLabel..not a good way to do it but
		// works for now..
		ImageIcon image = new ImageIcon("MainImage.jpg");
		JLabel graphic = new JLabel(image);
		
		// Make Jpanel where image will be put on.
		JPanel panel = new JPanel(new BorderLayout());
		// Set bounds and background color
		panel.setBounds(0, 0, 1000, 1000);
		panel.setBackground(Color.BLACK);
		// Add image to center of panel
		panel.add(graphic, BorderLayout.CENTER);
		// Add panel to frame
		menuFrame.add(panel);
		menuFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("knowledge".equals(e.getActionCommand())){			
		}

	}

	public void main(String[] args) throws IOException {
		displayMenu();
	}

}
