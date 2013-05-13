package actionGUI;

import itemCards.Axe;
import itemCards.Candle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;

import roomGUI.RoomFrame;
import rooms.Location;
import rooms.Room.Floor_Name;

import characters.ExplorerFactory;
import characters.Character.Character_Name;
import characters.Character;

import Game.Game;

public class ActionFrame extends JFrame {
	
	private StatPanel stats = new StatPanel();
	private ActionPanel actions = new ActionPanel();
	
	
	public ActionFrame(){
		this(250,500);
	}
	
	public ActionFrame(int width, int height){
		this.setSize(width, height);
		this.setTitle("Information Frame"); //Probably needs to be changed but this will work for now
		
		GridLayout layout = new GridLayout(3, 1); //Change back to 2 when remove Update button
		this.setLayout(layout);
		
		this.add(stats);
		this.add(actions);
		
		//Make a update button for now, so we don't have to auto update
		JButton update = new JButton("Update");
		
		update.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ActionFrame.this.update();
			}
		});
		
		this.add(update);
	}

	
	public void display(){
		this.setVisible(true);
		this.repaint();
	}
	
	//Probably bad naming convention because there is a update(Graphics G) but whatever.
	public void update(){
		this.stats.update();
		this.actions.update();
		
		this.repaint();
	}
	
	//Just for testing ActionFrames. Remove later for actual game play
	public static void main(String[] args) {
		ExplorerFactory explorers = new ExplorerFactory();
		
		Character father = explorers.getExplorer(Character_Name.FatherRhinehardt);
		Character two = explorers.getExplorer(Character_Name.BrandonJaspers);
		
		father.setCurrentRoom(Game.getInstance().getRoomAtLocation(new Location(Floor_Name.GROUND,0,0)));
		two.setCurrentRoom(Game.getInstance().getRoomAtLocation(new Location(Floor_Name.GROUND,0,0)));
		
		father.addItemCard(new Candle(new Locale("us")));
		
		Game.getInstance().addCharacter(father);
		Game.getInstance().addCharacter(two);
		
		ActionFrame actionFrame = new ActionFrame();
		actionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		actionFrame.display();
		
		RoomFrame rf = new RoomFrame();
		rf.display();

	}

	

}
