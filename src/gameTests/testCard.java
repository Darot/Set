package gameTests;

import static org.junit.Assert.*;
import game.Cards;

import org.junit.Before;
import org.junit.Test;

public class testCard {
	public Cards card = null;
	
	@Before
	public void setUp() throws Exception {
		Cards card = new Cards("red", "stripped", "diamond");
		this.card = card;
	}

	@Test
	public void testConstruct() {
		assertEquals("Object Attribute should be set", card.isSelected(), false);
		assertEquals("Object Attribute should be set", card.getColour(), "red");
		assertEquals("Object Attribute should be set", card.getPadding(), "stripped");
		assertEquals("Object Attribute should be set", card.getSymbol(), "diamond");
	}
	
	@Test 
	public void testSetSelected() {
		card.setSelected(true);
		assertEquals("Should set selected to true", card.isSelected(), true);
	}
	
	@Test
	public void testSetColour() {
		card.setColour("green");
		assertEquals("Should set coulour to green", card.getColour(), "green");
	}
	
	@Test
	public void testSetPadding(){
		card.setPadding("empty");
		assertEquals("Should set padding to empty", card.getPadding(), "empty");
	}
	
	@Test
	public void testSetSymbol(){
		card.setSymbol("square");
		assertEquals("should set Symbol to square", card.getSymbol(), "square");
		
	}
	
	

}
