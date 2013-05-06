package Game;

import java.io.IOException;

import popUps.GameFrame;

public class GameRunner {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		GameFrame win = new GameFrame();
//		//win.displayMenu();
//		
//		TraitPopup pop = new TraitPopup();
//		pop.displayChooseRollTypePopup();
//		pop.displayChooseMentalPopup();
//		pop.displayChoosePhysicalPopup();
//		
//		DeckAndCardPopups deck = new DeckAndCardPopups();
//		deck.displayChooseDeckPopup();
		GameFrame.displayMenu();
	}

}
