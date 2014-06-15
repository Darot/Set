package set.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javafx.event.ActionEvent;
import set.controller.ScreenController;

/**
 *
 * @author zeus
 */
public interface ControlledScreen {
    
    //this method will allow the injection of the Parent ScreenPane
    public void setScreenParent(ScreenController screenParent);
    
    public void goToMain(ActionEvent event);
    
}
