package popUps;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements ActionListener {

	private int width;
	private int height;
	
	public GameFrame(int windowWidth, int windowHeight) {
		this.width = windowWidth;
		this.height = windowHeight;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //make it close when it's closed.
		
	}

	public GameFrame() {
		
	}
	
	public static void displayMenu(){
		
		JFrame menuFrame = new JFrame("Betrayal at House on the Hill");
		menuFrame.setSize(1000,1000);
		Image image = Toolkit.getDefaultToolkit().getImage( "MainImage.jpg" );
		JPanel j = new JPanelWithBackground(image);
		menuFrame.add(j);
		j.setLayout(new FlowLayout());
		FrameComponent sidePanel = new FrameComponent();
		menuFrame.add(sidePanel);
		menuFrame.setVisible(true);	
		j.repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void main(String[] args){
		displayMenu();
	}

	
		
}


