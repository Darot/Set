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
public class ConfigurationMenuController implements Initializable, ControlledScreen {

    ScreenController controller;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void addPlayer1() {
        System.out.println("not implemented yet!");
    }

    public void addPlayer2() {
        System.out.println("not implemented yet!");
    }

    public void addPlayer3() {
        System.out.println("not implemented yet!");
    }

    public void addPlayer4() {
        System.out.println("not implemented yet!");
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
        System.out.println("not implemented yet!");
    }

}
