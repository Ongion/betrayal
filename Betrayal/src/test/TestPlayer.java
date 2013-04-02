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
		Assert.assertEquals(Father, ptCharacters().get(0));
	}
	
	@Test
	public void testOmenHand() {
		OmenCard card = new CrystalBall("test","test 2",game);
		
		p.addOmenCard(card);
		
		ArrayList<OmenCard> oHand = ptOmenHand();
		
		Assert.assertEquals(oHand.size(), 1);
		
		Assert.assertTrue(oHand.contains(card));
		
		p.removeOmenCard(card);
		
		Assert.assertEquals(oHand.size(), 0);
		
		Assert.assertFalse(oHand.contains(card));
		
	}
	
	@Test
	public void testItemHand() {
		ItemCard card = new AngelFeather(null, null);
		
		p.addItemCard(card);
		
		ArrayList<ItemCard> oHand = p.getItemHand();
		
		Assert.assertEquals(oHand.size(), 1);
		
		Assert.assertTrue(oHand.contains(card));
		
		p.removeItemCard(card);
		
		Assert.assertEquals(oHand.size(), 0);
		
		Assert.assertFalse(oHand.contains(card));
	}
	
	@Test
	public void testEventHand() {
		EventCard card = new Rotten(null, null, null);
		
		p.addEventCard(card);
		
		ArrayList<EventCard> oHand = p.getEventHand();
		
		Assert.assertEquals(oHand.size(), 1);
		
		Assert.assertTrue(oHand.contains(card));
		
		p.removeEventCard(card);
		
		Assert.assertEquals(oHand.size(), 0);
		
		Assert.assertFalse(oHand.contains(card));

	}

}
