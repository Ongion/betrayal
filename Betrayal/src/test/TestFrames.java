package test;

import static org.junit.Assert.*;

import org.junit.Test;

import popUps.FrameComponent;
import popUps.GameFrame;
import popUps.TraitPopup;

public class TestFrames {

	private int width = 200;
	private int height = 100; 
	
	@Test
	public void TestGameFrameInit() {
		GameFrame testFrame = new GameFrame(width,height);
	}
	
	@Test
	public void TestGameFrameAddComponent(){
		GameFrame testFrame = new GameFrame(width,height);
		FrameComponent component = new FrameComponent();
		testFrame.add(component);
		
	}
	
	@Test 
	public void TestSetSizeMethod(){
		GameFrame testFrame = new GameFrame();
		testFrame.setSize(width, height);
		assertEquals(this.width, width);
		assertEquals(this.height, height);
	}
	
	@Test
	public void TestMenuFrame(){
		GameFrame menu = new GameFrame();
		menu.displayMenu();
	}
	
	@Test
	public void TestTraitPopups(){
		TraitPopup win = new TraitPopup();
		win.displayChooseMentalPopup();
		win.displayChoosePhysicalPopup();
		win.displayChooseRollTypePopup();
		
	}

}
