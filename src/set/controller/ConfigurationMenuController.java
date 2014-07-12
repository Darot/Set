/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.controller;

import interfaces.controller.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    Label cpuLabel;

    @FXML
    TextField player1Textarea;
    @FXML
    TextField player2Textarea;
    @FXML
    TextField player3Textarea;
    @FXML
    TextField player4Textarea;

    @FXML
    RadioButton red;
    @FXML
    RadioButton green;
    @FXML
    RadioButton blue;
    
    @FXML
    Button deletePlayer1;
    @FXML
    Button deletePlayer2;
    @FXML
    Button deletePlayer3;
    @FXML
    Button deletePlayer4;
    
    @FXML
    Button addPlayer1;
    @FXML
    Button addPlayer2;
    @FXML
    Button addPlayer3;
    @FXML
    Button addPlayer4;


    final ToggleGroup group = new ToggleGroup();

    ScreenController controller;

    private String colour;
    
    private boolean cpu;

    public ConfigurationMenuController() {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        red.setToggleGroup(group);
        blue.setToggleGroup(group);
        green.setToggleGroup(group);
        loadConfiguration("src/config/config.properties");
    }

    public void colourSelected(ActionEvent event) {
        red.setToggleGroup(group);
        blue.setToggleGroup(group);
        green.setToggleGroup(group);
        RadioButton btn = (RadioButton) event.getSource();
        btn.setSelected(true);
        colour = btn.getId();

    }

    public void allColoursSelected() {
        red.setToggleGroup(null);
        blue.setToggleGroup(null);
        green.setToggleGroup(null);
        red.setSelected(true);
        blue.setSelected(true);
        green.setSelected(true);
        colour = "all";
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
        player1Name.setText(" ");
    }

    public void deletePlayer2() {
        player2Name.setText(" ");
    }

    public void deletePlayer3() {
        player3Name.setText(" ");
    }

    public void deletePlayer4() {
        player4Name.setText(" ");
    }
    
    public void setCPU(){
        if(cpu == true){
            cpu = false;
        }else{
            cpu = true;
        }
        
        player2Name.setText("CPU");
        player3Name.setDisable(cpu);
        player4Name.setDisable(cpu);
        
        player2Textarea.setDisable(cpu);
        player3Textarea.setDisable(cpu);
        player4Textarea.setDisable(cpu);
        
        deletePlayer2.setDisable(cpu);
        deletePlayer3.setDisable(cpu);
        deletePlayer4.setDisable(cpu);
        
        addPlayer2.setDisable(cpu);
        addPlayer3.setDisable(cpu);
        addPlayer4.setDisable(cpu);
        
        deletePlayer3();
        deletePlayer4();
        
        if(cpu == true){
            cpuLabel.setText("CPU!");
        }else {
            cpuLabel.setText(" ");
        }
    }

    public void loadDefaults() {
        loadConfiguration("src/config/defaultConfig.properties");
    }

    private void loadConfiguration(String path) {
        Configurator configurator = new Configurator();
        configurator.loadConfiguration(path);
        //Set loaded values
        player1Name.setText(configurator.getPlayer1Name());
        player2Name.setText(configurator.getPlayer2Name());
        player3Name.setText(configurator.getPlayer3Name());
        player4Name.setText(configurator.getPlayer4Name());

        colour = configurator.getColour();
        if (colour.equals("all")) {
            allColoursSelected();
        }
        //ToDo : This could be better!?
        if (colour.equals("red")) {
            red.setSelected(true);
        }
        if (colour.equals("blue")) {
            blue.setSelected(true);
        }
        if (colour.equals("green")) {
            green.setSelected(true);
        }
        
        if(configurator.getCPU() == "true"){
            cpu = false;
        }
        setCPU();
    }

    public void saveConfiguration() {
        Configurator configurator = new Configurator();

        configurator.setColour(colour);

        configurator.setPlayer1Name(player1Name.getText());
        configurator.setPlayer2Name(player2Name.getText());
        configurator.setPlayer3Name(player3Name.getText());
        configurator.setPlayer4Name(player4Name.getText());

        configurator.setSymbol1("rectangle");
        configurator.setSymbol2("oval");
        configurator.setSymbol3("wave");
        
        if(cpu == true){
            configurator.setCPU("true");
        }else{
            configurator.setCPU("false");
        }

        configurator.writeConfiguration();
        //reload game view
        controller.unloadScreen(Set.GAME);
        controller.loadScreen(Set.GAME, Set.GAME_FXML);
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
