/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import set.model.GameCard;

/**
 *
 * @author zeus
 */
public class GameCardTest {

    public GameCard card = null;

    @Before
    public void setUp() {
        card = new GameCard("red", "stripped", "diamond");
    }

    @Test
    public void testConstruct() {
        assertEquals("Object Attribute should be set", card.isSelected(), false);

        assertEquals("Object Attribute should be set", card.getColour(), "red");

        assertEquals("Object Attribute should be set", card.getPadding(), "stripped");

        assertEquals("Object Attribute should be set", card.getSymbol(), "diamond");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
