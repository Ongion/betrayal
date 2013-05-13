package cardGUI;

import java.io.File;
import java.util.ArrayList;
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
		
		ArrayList<EventCard> eCards = new ArrayList<EventCard>();
		ArrayList<ItemCard> iCards = new ArrayList<ItemCard>();
		ArrayList<OmenCard> oCards = new ArrayList<OmenCard>();
		
		EventCard eCard = new HangedMen(en);
		ItemCard iCard1 = new DarkDice(en);
		ItemCard iCard2 = new Axe(en);
		ItemCard iCard3 = new Bell(en);
		OmenCard oCard = new Skull(en);
		
		//EventCardFrame frame = new EventCardFrame(eCard);
		//ItemCardFrame frame = new ItemCardFrame(iCard);
		//OmenCardFrame frame = new OmenCardFrame(oCard);
		
		eCards.add(eCard);
		iCards.add(iCard1);
		iCards.add(iCard2);
		iCards.add(iCard3);
		oCards.add(oCard);
		
//		EventCardPicker frame = new EventCardPicker(eCards);
//		OmenCardPicker frame = new OmenCardPicker(oCards);
		ItemCardPicker frame = new ItemCardPicker(iCards);
		
		frame.display();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}