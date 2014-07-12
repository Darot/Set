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
public class MainMenuController implements Initializable, ControlledScreen {

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

    //GUI navigation methods
    public void goToLoad(ActionEvent event) {
        controller.setScreen(Set.LOAD_GAME);
    }

    public void goToConfiguration(ActionEvent event) {
        controller.setScreen(Set.CONFIGURATION_MENU);
    }

    public void goToGame(ActionEvent event) {
        controller.setScreen(Set.GAME);
    }
    
    
    @Override
    public void exitGame(){
        System.out.println("not implemented yet!");
    }

}
