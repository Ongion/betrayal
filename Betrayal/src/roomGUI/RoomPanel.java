package roomGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JPanel;

import Game.Game;

import rooms.Room;
import rooms.Room.Relative_Direction;
import characters.Character;


public class RoomPanel extends JPanel {

	
	private Room room;
	
	//This is used to figure out the width of the String we are drawing, so that we can center the text
	private final double FONT_WIDTH_RATIO = 5.0/8;
	
	//These are the colors I am using
	private final Color background = new Color(110,80,0);
	private final Color border = Color.BLACK;
	private final Color exitColor = Color.RED;
	private final Color textColor = Color.YELLOW;
	private final Color characterColor = Color.BLUE;
	
	public RoomPanel(Room room){
		this.room = room;
		
		
		this.setVisible(true);
		this.setOpaque(false);
		
		this.setToolTipText(room.getName());
	}
	
	public void paint(Graphics g){
		System.out.println(ResourceBundle.getBundle("rooms/RoomsBundle", Game.getInstance().getLocale()));
		g.setColor(background);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(border);
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		
		String name = room.getName();
		
		int fSize = Math.min(72, Math.min( (this.getWidth()/name.length()) , this.getHeight()/4));
		
		int xOffset = (this.getWidth() - (int) (fSize * name.length()* FONT_WIDTH_RATIO))/2;
		
		Font f = new Font(Font.MONOSPACED,0,fSize);
		g.setFont(f);
		g.setColor(textColor);
		g.drawString(name, xOffset, fSize*2);
		
		
		this.drawCharacters(g ,20, fSize*3);
		
		this.drawExits(g);
		
		
		
		super.paint(g);
	}
	
	private void drawCharacters(Graphics g, int xOffset, int yOffset){
		ArrayList<Character> characters = Game.getInstance().getCharacters();
		
		Font f = new Font(Font.MONOSPACED,0,12);
		g.setFont(f);
		g.setColor(characterColor);
		
		for (Character c:characters){
			if (c.getCurrentRoom().equals(this.room)){
				g.drawString(c.getName(), xOffset, yOffset);
				yOffset += 17;
			}
		}
	}
	
	private void drawExits(Graphics g){
		g.setColor(exitColor);
		
		//int size = this.getWidth() / 10;
		int xPos = 0;
		int yPos = 0;
		int width = 0;
		int height = 0;
		
		for (Relative_Direction exit: room.getExits()){
			Relative_Direction dir = room.convertAbsoluteDirectionToRoomRelativeDirection(exit);
			
			
			switch (dir){
				case NORTH:
					height = 10;
					width = this.getWidth() / 2;
					yPos = 0;
					xPos = (this.getWidth() - width)/2;		
					break;
				case SOUTH:
					height = 10;
					width = this.getWidth() / 2;
					yPos = this.getHeight()-height;
					xPos = (this.getWidth() - width)/2;
					break;
				case EAST:
					width = 10;
					height = this.getHeight() / 2;
					yPos = (this.getHeight() - height)/2;
					xPos = 0;
					break;
				case WEST:
					width = 10;
					height = this.getHeight() / 2;
					yPos = (this.getHeight() - height)/2;
					xPos = this.getWidth()-width;
					break;
				default:
					continue;
			}
			
			g.fillRect(xPos, yPos, width, height);
			
		}
	}

}
