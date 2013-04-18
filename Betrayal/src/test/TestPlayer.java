package test;

import java.util.Locale;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Game.Game;
import Game.Player;
import characters.Character.Character_Name;
import characters.ExplorerType;
import characters.ExplorerFactory;
import characters.Character;

public class TestPlayer {

	Player p;
	Character Father;
	Game game;
	
	@Before
	public void initTests() {
		ExplorerFactory explorers = new ExplorerFactory();
		Father = explorers.getExplorer(Character_Name.FatherRhinehardt);
		p = new Player();
		p.addCharacter(Father);
	}
	
	@Test
	public void testInitialize() {
		Assert.assertNotNull(p);
	}
	
	@Test
	public void testGetCharacter() {
		Assert.assertEquals(Father, p.getCharacters().get(0));
	}
}
