package cardGUI;

import java.io.File;
import java.util.Locale;

import javax.swing.JFrame;

import itemCards.*;
import eventCards.*;
import omenCards.*;

public class TestingClass {

	/**
	 * This classes only purpose is testing displaying of Cards. Should be deleted after testing is complete.
	 */
	public static void main(String[] args) {
		Locale en = new Locale("US");
		
		EventCard eCard = new HangedMen(en);
		ItemCard iCard = new DarkDice(en);
		OmenCard oCard = new Skull(en);
		
		//EventCardFrame frame = new EventCardFrame(eCard);
		//ItemCardFrame frame = new ItemCardFrame(iCard);
		OmenCardFrame frame = new OmenCardFrame(oCard);
		
		frame.display();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}