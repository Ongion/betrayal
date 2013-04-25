package popUps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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
	
	public void displayMenu(){
		
		JFrame menuFrame = new JFrame();
		menuFrame.setSize(500,500);
		menuFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
		
}


