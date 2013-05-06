package cardGUI;

import java.io.File;
import java.util.Locale;

import javax.swing.JFrame;

import eventCards.*;

public class TestingClass {

	/**
	 * This classes only purpose is testing displaying of Cards. Should be deleted after testing is complete.
	 */
	public static void main(String[] args) {
		Locale en = new Locale("US");
		
		EventCard angryBeing = new HangedMen(en);
		
		EventCardFrame angryFrame = new EventCardFrame(angryBeing);
		
		angryFrame.display();
		angryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}