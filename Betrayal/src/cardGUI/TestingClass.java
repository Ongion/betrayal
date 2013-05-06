package cardGUI;

import java.util.Locale;

import eventCards.AngryBeing;
import eventCards.EventCard;

public class TestingClass {

	/**
	 * This classes only purpose is testing displaying of Cards. Should be deleted after testing is complete.
	 */
	public static void main(String[] args) {
		Locale en = new Locale("US");
		
		EventCard angryBeing = new AngryBeing(en);
		
		EventCardFrame angryFrame = new EventCardFrame(angryBeing);

	}

}
