package actionGUI;

import java.awt.GridLayout;

import javax.swing.JFrame;

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
		
		GridLayout layout = new GridLayout(2, 1);
		this.setLayout(layout);
		
		this.add(stats);
		this.add(actions);
	}

	//Just for testing ActionFrames. Remove later for actual game play
	public static void main(String[] args) {
		ExplorerFactory explorers = new ExplorerFactory();
		Character father = explorers.getExplorer(Character_Name.FatherRhinehardt);
		
		father.setCurrentRoom(Game.getInstance().getRoomAtLocation(new Location(Floor_Name.GROUND,0,0)));
		
		Game.getInstance().addCharacter(father);
		
		ActionFrame actionFrame = new ActionFrame();
		actionFrame.display();

	}
	
	public void display(){
		this.setVisible(true);
		this.repaint();
	}
	
	//Probably bad naming convention because there is a update(Graphics G) but whatever.
	public void update(){
		this.stats.update();
		this.actions.update();
	}
	

}
