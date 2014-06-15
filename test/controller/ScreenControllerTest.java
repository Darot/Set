/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import set.controller.ScreenController;

/**
 *
 * @author zeus
 */
public class ScreenControllerTest {
    
    ScreenController controller = null;
    
    public ScreenControllerTest() {
    }
    
    @Before
    public void setUp() {
        controller = new ScreenController();
    }
    
    @Test
    public void testMap(){
        assertNull("Empty HashMap should exist", controller.getScreen(0));
    }
    
}
