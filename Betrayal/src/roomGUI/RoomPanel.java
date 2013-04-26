package roomGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import rooms.Room;
import rooms.Room.Relative_Direction;



public class RoomPanel extends JPanel {

	
	private Room room;
	
	//This is used to figure out the width of the String we are drawing, so that we can center the text
	private final double FONT_WIDTH_RATIO = 5.0/8;
	
	//These are the colors I am using
	private final Color background = new Color(110,80,0);
	private final Color border = Color.BLACK;
	private final Color exitColor = Color.RED;
	private final Color textColor = Color.YELLOW;
	
	public RoomPanel(Room room){
		this.room = room;
		
		
		this.setVisible(true);
		this.setOpaque(false);
		
		this.setToolTipText(room.getName());
	}
	
	public void paint(Graphics g){
		
		g.setColor(background);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(border);
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		
		String name = room.getName();
		
		int fSize = Math.min(72, Math.min( (this.getWidth()/name.length()) , this.getHeight()/4));
		
		int xOffset = (this.getWidth() - (int) (fSize * name.length()*FONT_WIDTH_RATIO))/2;
		
		Font f = new Font(Font.MONOSPACED,0,fSize);
		g.setFont(f);
		g.setColor(textColor);
		g.drawString(name, xOffset, fSize*2);
		
		this.drawExits(g);
		
		super.paint(g);
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