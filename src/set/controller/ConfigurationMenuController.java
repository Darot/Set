
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
import javafx.scene.input.MouseEvent;
import set.Set;
import set.services.Configurator;

/**
 * FXML Controller class
 *
 * @author Sebastian Neiss
 * 
 * This class controlls all elements of the configuration View.
 * The configuration service is used to store thos configurations
 * in a properties file with the properties API.
 * 
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
    RadioButton oval;
    @FXML
    RadioButton rectangle;
    @FXML
    RadioButton star;
    @FXML
    RadioButton wave;
    @FXML
    RadioButton diamond;
    @FXML
    RadioButton heart;

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
    
    @FXML
    Button save;

    //the toggle group for color selection radio buttons
    final ToggleGroup group = new ToggleGroup();

    ScreenController controller;

    private String colour;

    private boolean cpu;

    private String[] symbols = new String[3];

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        red.setToggleGroup(group);
        blue.setToggleGroup(group);
        green.setToggleGroup(group);
        //load the configuration -> this will set all GUI elements
        loadConfiguration("src/config/config.properties");
    }

    /**
     * This method handles the selection of a color.
     * Its called when a button of a color is clicked.
    */
    public void colourSelected(ActionEvent event) {
        red.setToggleGroup(group);
        blue.setToggleGroup(group);
        green.setToggleGroup(group);
        RadioButton btn = (RadioButton) event.getSource();
        btn.setSelected(true);
        colour = btn.getId();

    }

    /**
     * This method will be called when the "ALL COLORS" button
     * is clicked.
     * It removes the radio buttons from the toggle group.
    */
    public void allColoursSelected() {
        red.setToggleGroup(null);
        blue.setToggleGroup(null);
        green.setToggleGroup(null);
        red.setSelected(true);
        blue.setSelected(true);
        green.setSelected(true);
        colour = "all";
    }

    /**
     * add / remove players
     */
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

    /**
     * This is weird algorithm to guarantee the user has to pick exact 3
     * symbols. (toggle groups do not have a feature like that)
     * 
     * @param event 
     */
    public void setSymbol(ActionEvent event) {
        RadioButton btn = (RadioButton) event.getSource();
        String symbol = btn.getId();
        System.out.println(symbol);
        if (btn.isSelected()) {
            System.out.println("is selected");
            if(!checkSymbolCount()){
                btn.setSelected(false);
            }else{
                for (int i = 0; i < symbols.length; i++) {
                    if (symbols[i] == null) {
                        symbols[i] = symbol;
                        i = 3;
                        //Only release the save button when 3 symbols picked
                        if(!checkSymbolCount()){
                            save.setDisable(false);
                        }
                    }   
                }
            }
        }

        else if (!btn.isSelected()) {
            save.setDisable(true);
            for (int i = 0; i < symbols.length; i++) {
                System.out.println("no selected");
                    if(symbols[i] == null){
                        
                    }
                    else if (symbols[i].equals(symbol)) {
                        symbols[i] = null;
                    }   
                }
        }
        
    }

    /**
     * Checks if there are symbols left to pick.
     * 
     * @return true / false
     */
    public boolean checkSymbolCount() {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Handles the "Play against cpu" button and deactivates all other
     * players when clicked.
     */
    public void setCPU() {
        if (cpu == true) {
            cpu = false;
        } else {
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

        if (cpu == true) {
            cpuLabel.setText("CPU!");
        } else {
            cpuLabel.setText(" ");
            cpuLabel.setDisable(true);
        }
    }

    /**
     * Loads default settings file
     */
    public void loadDefaults() {
        loadConfiguration("src/config/defaultConfig.properties");
    }

    
    /**
     * Loads a give configuration file and sets all GUI Elements to
     * the loaded values
     * 
     * @param path 
     */
    private void loadConfiguration(String path) {
        Configurator configurator = new Configurator();
        configurator.loadConfiguration(path);
        
        //Set loaded values
        player1Name.setText(configurator.getPlayer1Name());
        player2Name.setText(configurator.getPlayer2Name());
        player3Name.setText(configurator.getPlayer3Name());
        player4Name.setText(configurator.getPlayer4Name());

        symbols[0] = configurator.getSymbol1();
        symbols[1] = configurator.getSymbol2();
        symbols[2] = configurator.getSymbol3();

        
        //ToDo : This could be better!?
        for (int i = 0; i <= 2; i++) {
            if (symbols[i].equals("rectangle")) {
                rectangle.setSelected(true);
            }
            if (symbols[i].equals("oval")) {
                oval.setSelected(true);
            }
            if (symbols[i].equals("wave")) {
                wave.setSelected(true);
            }
            if (symbols[i].equals("star")) {
                star.setSelected(true);
            }
            if (symbols[i].equals("heart")) {
                heart.setSelected(true);
            }
            if (symbols[i].equals("diamond")) {
                diamond.setSelected(true);
            }
        }

        colour = configurator.getColour();
        if (colour.equals("all")) {
            allColoursSelected();
        }
        if (colour.equals("red")) {
            red.setSelected(true);
        }
        if (colour.equals("blue")) {
            blue.setSelected(true);
        }
        if (colour.equals("green")) {
            green.setSelected(true);
        }

        if (configurator.getCPU() == "true") {
            cpu = false;
        }
        setCPU();
    }

    /**
     * Saves the configuration to a properties file.
     */
    public void saveConfiguration() {
        Configurator configurator = new Configurator();

        for (int i = 0; i >= 6; i++) {

        }

        configurator.setColour(colour);

        configurator.setPlayer1Name(player1Name.getText());
        configurator.setPlayer2Name(player2Name.getText());
        configurator.setPlayer3Name(player3Name.getText());
        configurator.setPlayer4Name(player4Name.getText());

        configurator.setSymbol1(symbols[0]);
        configurator.setSymbol2(symbols[1]);
        configurator.setSymbol3(symbols[2]);

        if (cpu == true) {
            configurator.setCPU("true");
        } else {
            configurator.setCPU("false");
        }

        configurator.writeConfiguration();
        //reload game view
        controller.unloadScreen(Set.GAME);
        controller.loadScreen(Set.GAME, Set.GAME_FXML);
    }

    /**
     * Injects the screen parent.
     * 
     * @param screenParent 
     */
    @Override
    public void setScreenParent(ScreenController screenParent) {

        controller = screenParent;
    }

    /**
     * Navigation 
     */
    
    public void goToMain(ActionEvent event) {

        controller.setScreen(Set.MAIN_MENU);
    }

    @Override
    public void exitGame() {
        System.out.println("not implemented yet!");
    }

}
