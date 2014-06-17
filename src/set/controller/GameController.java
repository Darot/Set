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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import set.Set;

/**
 * FXML Controller class
 *
 * @author zeus
 */
public class GameController implements Initializable, ControlledScreen {
   
    @FXML
    private ImageView card1;
    
    ScreenController controller;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initGame(ActionEvent event){
        //final ImageView card1 = new ImageView();
        Image image1 = new Image(Set.class.getResourceAsStream("/resources/cards/cards-icon.png"));
        //image1.isError();
        card1.setImage(image1);
    }

    public void goToMain(ActionEvent event){
        controller.setScreen(Set.MAIN_MENU);
    }
    
    @Override
    public void setScreenParent(ScreenController screenParent) {
        controller = screenParent;
    }

    @Override
    public void exitGame() {
        System.out.println("not implemented yet!");
    }
    
}
