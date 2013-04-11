package test;

import itemCards.AngelFeather;
import itemCards.ItemCard;

import java.util.ArrayList;
import java.util.Locale;

import junit.framework.Assert;

import omenCards.CrystalBall;
import omenCards.OmenCard;

import org.junit.Before;
import org.junit.Test;

import Game.Game;
import Game.Player;

import characters.Character;
import eventCards.EventCard;
import eventCards.Rotten;

public class TestPlayer {

	Player p;
	Character Father;
	Game game;
	
	@Before
	public void initTests() {
		Father = new Character(0,new Locale("en"));
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
