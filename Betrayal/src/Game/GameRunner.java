package Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

import actionGUI.ActionFrame;

import characters.Character.Character_Name;
import characters.ExplorerFactory;
import characters.Trait;

import popUps.GameFrame;
import roomGUI.RoomFrame;
import rooms.Location;
import rooms.Room;
import rooms.Room.Floor_Name;
import characters.Character;

public class GameRunner {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		GameFrame win = new GameFrame();
//		win.displayMenu();
//		
//		TraitPopup pop = new TraitPopup();
//		pop.displayChooseRollTypePopup();
//		pop.displayChooseMentalPopup();
//		pop.displayChoosePhysicalPopup();
//		
//		DeckAndCardPopups deck = new DeckAndCardPopups();
//		deck.displayChooseDeckPopup();
//		GameFrame.displayMenu();
		
		
//		String localizedSanity = dialogBoxBundle.getString("SanityTrait");
//		String localizedKnowledge = dialogBoxBundle.getString("KnowledgeTrait");
//		String localizedMessage = dialogBoxBundle.getString("MentalTraitChoiceMessage");
		
		
		//Start the Game
		
		//Determine the number of characters
		Object[] options = {1, 2, 3, 4, 5, 6};
		
		int dialogResult = JOptionPane.CLOSED_OPTION;
		while (dialogResult == JOptionPane.CLOSED_OPTION) {
			dialogResult = JOptionPane.showOptionDialog(null, "Choose the number of Characters", "Choose the number of Characters", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		int numChars = dialogResult + 1;
		
		//Create ArrayList of possible Characters
		ArrayList<Character> charactersToChoose = new ArrayList<Character>();
		ExplorerFactory explorers = new ExplorerFactory();
		
		for (Character_Name name : Character_Name.values()){
			charactersToChoose.add(explorers.getExplorer(name));
		}
		
		//Choose all the Characters to play
		Room entrance = Game.getInstance().getRoomAtLocation(new Location(Floor_Name.GROUND,0,0));
		for (int i = 0; i < numChars; i++){
			dialogResult = JOptionPane.CLOSED_OPTION;
			while (dialogResult == JOptionPane.CLOSED_OPTION) {
				dialogResult = JOptionPane.showOptionDialog(null, "Choose character number " + (i+1),"Choose Character" , JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, charactersToChoose.toArray(), charactersToChoose.toArray()[0]);
			}
			
			Character toAdd = charactersToChoose.remove(dialogResult);
			
			//Find the other character on the same card to remove
			int otherToRemove = dialogResult - (dialogResult % 2);
			charactersToChoose.remove(otherToRemove);
			
			//Add the chosen character to the game and starting at the entrance
			toAdd.setCurrentRoom(entrance);
			Game.getInstance().addCharacter(toAdd);
		}
		
		//Display Rooms
		RoomFrame rf = new RoomFrame();
		rf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		rf.display();
		
		ActionFrame actionFrame = new ActionFrame();
		actionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		actionFrame.display();
		
	}
	
	

}
