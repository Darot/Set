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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import set.Set;
import set.services.Configurator;

/**
 * FXML Controller class
 *
 * @author zeus
 */
public class ConfigurationMenuController implements Initializable, ControlledScreen {

    @FXML
    Label player1Name;
    @FXML
    Label player2Name;
    @FXML
    Label player3Name;
    @FXML
    Label player4Name;
    @FXML
    TextField player1Textarea;
    @FXML
    TextField player2Textarea;
    @FXML
    TextField player3Textarea;
    @FXML
    TextField player4Textarea;

    ScreenController controller;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void addPlayer1() {
        player1Name.setText(player1Textarea.getText());
    }

    public void addPlayer2() {
        player2Name.setText(player2Textarea.getText());
    }

    public void addPlayer3() {
        player3Name.setText(player3Textarea.getText());
    }

    public void addPlayer4() {
        player4Name.setText(player4Textarea.getText());
    }

    public void deletePlayer1() {
        player1Name.setText("");
    }

    public void deletePlayer2() {
        player2Name.setText("");
    }

    public void deletePlayer3() {
        player3Name.setText("");
    }

    public void deletePlayer4() {
        player4Name.setText("");
    }

    public void loadConfiguration() {
        Configurator configurator = new Configurator();
        configurator.loadConfiguration("src/config/config.properties");
        //Set loaded values
        player1Name.setText(configurator.getPlayer1Name());
        player2Name.setText(configurator.getPlayer2Name());
        player3Name.setText(configurator.getPlayer3Name());
        player4Name.setText(configurator.getPlayer4Name());
    }

    public void saveConfiguration() {
        Configurator configurator = new Configurator();
        configurator.writeConfiguration();
        
        configurator.setColour1("red");
        configurator.setColour2("green");
        configurator.setColour3("blue");
        
        configurator.setPlayer1Name(player1Name.getText());
        configurator.setPlayer2Name(player2Name.getText());
        configurator.setPlayer3Name(player3Name.getText());
        configurator.setPlayer4Name(player4Name.getText());
        
        configurator.setSymbol1("rectangle");
        configurator.setSymbol2("oval");
        configurator.setSymbol3("wave");
        
        configurator.writeConfiguration();
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
