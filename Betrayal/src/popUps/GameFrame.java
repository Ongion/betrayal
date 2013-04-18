package popUps;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

	private int width;
	private int height;
	
	public GameFrame(int windowWidth, int windowHeight) {
		this.width = windowWidth;
		this.height = windowHeight;
		
	}

	public GameFrame() {
		
	}
	
public void displayMenu(){
	
	JFrame menuFrame = new JFrame();
	menuFrame.setSize(500,500);
	menuFrame.setVisible(true);
	
}
		
	}


