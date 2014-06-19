/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package set.controller;

import interfaces.controller.ControlledScreen;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import set.Set;
import set.model.Game;
import set.model.GameCard;

/**
 * FXML Controller class
 *
 * @author zeus
 */
public class GameController implements Initializable, ControlledScreen {
   
    @FXML
    private ImageView card1;
    private ImageView card2;
    private ImageView card3;
    private ImageView card4;
    private ImageView card5;
    private ImageView card6;
    private ImageView card7;
    private ImageView card8;
    private ImageView card9;
    private ImageView card10;
    private ImageView card11;
    private ImageView card12;
    private ImageView card13;
    private ImageView card14;
    private ImageView card15;
    private ImageView card16;
    
    @FXML
    private Button setPlayer1;
    private Button setPlayer2;
    private Button setPlayer3;
    private Button setPlayer4;
    
    private Game game;
    
    private String set = null;
    
    private GameCard[] cardPositions;
    
    ScreenController controller;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setClicked(ActionEvent event){
        Button btn = (Button) event.getSource();
        System.out.println(btn.getId());
//        System.out.println(event.getSource().equals(setPlayer2));
//        if(event.getSource().equals(setPlayer2)){
//            System.out.println("player2");
//        }
    }
    
    public void cardClicked(MouseEvent event){
        ImageView card = (ImageView) event.getSource();
        String cardId = card.getId();
        System.out.println(cardId);
//        String id = event.getSource().toString();
//        id = id.substring(13, id.length() - 1);
//        System.out.println(id);
        if(set == null){
            System.out.println("Card clicked - CALL SET FIRST!");
        }else{
            //TODO
        }
        
    }
    
    public void initGame(ActionEvent event){
        //String imgPath;
        //Image image1 = new Image(Set.class.getResourceAsStream("/resources/cards/blue-solid-rectangle-3.jpg"));
        //card1.setImage(image1);
        //imgPath = game.pickCard().getImagePath();
        //Image i1 = new Image(Set.class.getResourceAsStream(imgPath));
        //card1.setImage(i1);
    }
    
    public GameController(){
        game = new Game();
        game.generateCards("oval", "rectangle", "wave", "red", "green", "blue");
        game.shuffleCards();
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
