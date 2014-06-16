/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package set.controller;

import interfaces.controller.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import set.Set;

/**
 * FXML Controller class
 *
 * @author zeus
 */
public class SplashController implements Initializable, ControlledScreen {
    
    ScreenController controller;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreenController screenParent) {
            controller = screenParent;
    }

    public void goToMain(ActionEvent event) {
        controller.setScreen(Set.MAIN_MENU);
    }

    @Override
    public void exitGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
