package popUps;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;


public class FrameComponent extends JComponent{	

	@Override
    protected void paintComponent(Graphics g) {
     
       g.drawRect(0,0,200,1000);
       g.fillRect(0, 0, 200, 1000);
    }

}
