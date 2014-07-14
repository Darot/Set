package interfaces.controller;

import javafx.event.ActionEvent;
import set.controller.ScreenController;
import set.controller.ScreenController;

/**
 *
 * @author Daniel Roth
 */
public interface ControlledScreen {
    //This interface is used by all screen controllers
   
    //this method will allow the injection of the Parent ScreenPane
    public void setScreenParent(ScreenController screenParent);
    
    public void exitGame();
    
    
}
