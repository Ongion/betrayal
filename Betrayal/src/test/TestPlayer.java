package test;

import static org.junit.Assert.*;

import java.util.Locale;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Game.Player;

import characters.Character;

public class TestPlayer {

	Player p;
	
	@Before
	public void initTests() {
		p = new Player(new Character(0,new Locale("en")));
	}
	
	@Test
	public void testInitialize() {
		Assert.assertNotNull(p);
	}

}
