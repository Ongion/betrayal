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

import Game.Player;

import characters.Character;
import eventCards.EventCard;
import eventCards.Rotten;

public class TestPlayer {

	Player p;
	Character Father;
	
	@Before
	public void initTests() {
		Father = new Character(0,new Locale("en"));
		p = new Player(Father);
	}
	
	@Test
	public void testInitialize() {
		Assert.assertNotNull(p);
	}
	
	@Test
	public void testGetCharacter() {
		Assert.assertEquals(Father, p.getCharacter());
	}
	
	@Test
	public void testOmenHand() {
		OmenCard card = new CrystalBall("test","test 2");
		
		p.addOmenCard(card);
		
		ArrayList<OmenCard> oHand = p.getOmenHand();
		
		Assert.assertEquals(oHand.size(), 1);
		
		Assert.assertTrue(oHand.contains(card));
		
	}
	
	@Test
	public void testItemHand() {
		ItemCard card = new AngelFeather(null, null);
		
		p.addItemCard(card);
		
		ArrayList<ItemCard> oHand = p.getItemHand();
		
		Assert.assertEquals(oHand.size(), 1);
		
		Assert.assertTrue(oHand.contains(card));
		
	}
	
	@Test
	public void testEventHand() {
		EventCard card = new Rotten(null, null, p.getCharacter());
		
		p.addEventCard(card);
		
		ArrayList<EventCard> oHand = p.getEventHand();
		
		Assert.assertEquals(oHand.size(), 1);
		
		Assert.assertTrue(oHand.contains(card));

	}

}
