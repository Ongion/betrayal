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
		
		GridLayout layout = new GridLayout(2, 1);
		this.setLayout(layout);
		
		this.add(stats);
		this.add(actions);
		
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
	
}
