package roomGUI;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Game.Game;

import rooms.Location;
import rooms.Room;
import rooms.Room.Floor_Name;
import rooms.Room.Room_Orientation;
import rooms.RoomFactory;
import rooms.RoomName;

public class RoomFrame extends JFrame implements ActionListener {

	/**
	 * Ya I really don't know what this is for but Eclipse always wants it.
	 */
	private static final long serialVersionUID = -3760776083872024631L;

	//Used to store all the rooms, and switch between the floors
	private JPanel groundPanel = new JPanel();
	private JPanel basementPanel = new JPanel();
	private JPanel upperPanel = new JPanel();
	
	//Menubar stuff
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Floor");
	private JMenuItem groundMenuItem = new JMenuItem("Ground Floor");
	private JMenuItem basementMenuItem = new JMenuItem("Basement");
	private JMenuItem upperMenuItem = new JMenuItem("Upper Floor");
	

	public RoomFrame(){
		this(400,400);
	}

	public RoomFrame(int width, int height){

		//this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); Probably don't actually want this in the code for real.
		//I'll add it to my main to make testing easier though
		this.setSize(width, height);
		this.setTitle("Betrayal Rooms");
		
		groundMenuItem.addActionListener(this);
		basementMenuItem.addActionListener(this);
		upperMenuItem.addActionListener(this);
		
		menu.add(upperMenuItem);
		menu.add(groundMenuItem);
		menu.add(basementMenuItem);
		
		
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		
		this.addRoomPanels();

	}

	public void addRoomPanels() {
		Game g = Game.getInstance();


		ArrayList<Room> ground  = new ArrayList<Room>();
		ArrayList<Room> basement  = new ArrayList<Room>();
		ArrayList<Room> upper  = new ArrayList<Room>();

		for (Room r: g.getMapRooms()){
			Location l = r.getLocation();
			switch (l.getFloor()){
				case BASEMENT:
					basement.add(r);
					break;
				case GROUND:
					ground.add(r);
					break;
				case UPPER:
					upper.add(r);
					break;
				default:
					//What the fuck? Why are you here?
					break;
			}
		}
		
		addRoomsToFrameInGrid(ground, groundPanel);
		addRoomsToFrameInGrid(basement, basementPanel);
		addRoomsToFrameInGrid(upper, upperPanel);

		

		this.add(groundPanel);
	}

	private void addRoomsToFrameInGrid(ArrayList<Room> rooms, JPanel panel){
		if (!rooms.isEmpty()){
			Location first = rooms.get(0).getLocation();
			int minX, maxX;
			minX = maxX = first.getX();

			int minY, maxY;
			minY = maxY = first.getY();

			for (Room r: rooms){
				int curX = r.getLocation().getX();
				int curY = r.getLocation().getY();

				minX = Math.min(minX, curX);
				maxX = Math.max(maxX, curX);

				minY = Math.min(minY, curY);
				maxY = Math.max(maxY, curY);
			}

			int width = maxX - minX + 1;
			int height = maxY - minY + 1;

			GridLayout gridLayout = new GridLayout(width,height);
			panel.setLayout(gridLayout);

			Room[][] roomGrid = new Room[width][height];
			for (Room r: rooms){
				Location l = r.getLocation();

				roomGrid[l.getX()- minX][l.getY() - minY]  = r;
			}

			for (int i = 0; i < width; i++){
				for (int j = 0; j < height; j++){
					if (roomGrid[i][j] != null){
						panel.add(new RoomPanel(roomGrid[i][j]));
					} else {
						panel.add(new JPanel());
					}
				}
			}

		}
		
	}

	public void display(){
		this.setVisible(true);
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.remove(basementPanel);
		this.remove(groundPanel);
		this.remove(upperPanel);
		if (upperMenuItem.equals(event.getSource())){	
			this.add(upperPanel);
		}
		if (groundMenuItem.equals(event.getSource())){
			this.add(groundPanel);
			groundPanel.setVisible(true);
			
		}
		if (basementMenuItem.equals(event.getSource())){	
			this.add(basementPanel);
		}
		
		this.display();
		
	}

	//This should be removed later on. This is used to test this GUI Window and just display it without messing with everyone else's code.
	public static void main(String[] args){
		Game.resetGame();
		RoomFrame rf = new RoomFrame();
		rf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		RoomFactory rooms = new RoomFactory();
		Room r1 = rooms.makeRoom(RoomName.DININGROOM);
		Room r2 = rooms.makeRoom(RoomName.GARDENS);
		Room r3 = rooms.makeRoom(RoomName.ORGANROOM);

		r1.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 0,0));
		r2.setPlacement(Room_Orientation.NORTH, new Location(Floor_Name.GROUND, 1,1));
		r3.setPlacement(Room_Orientation.WEST, new Location(Floor_Name.UPPER, 2,0));

		//rf.addRoomPanels();

		rf.display();
	}

	

}
