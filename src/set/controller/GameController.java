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
    @FXML
    private ImageView card2;
    @FXML
    private ImageView card3;
    @FXML
    private ImageView card4;
    @FXML
    private ImageView card5;
    @FXML
    private ImageView card6;
    @FXML
    private ImageView card7;
    @FXML
    private ImageView card8;
    @FXML
    private ImageView card9;
    @FXML
    private ImageView card10;
    @FXML
    private ImageView card11;
    @FXML
    private ImageView card12;
    @FXML
    private ImageView card13;
    @FXML
    private ImageView card14;
    @FXML
    private ImageView card15;
    @FXML
    private ImageView card16;

    @FXML
    private Button setPlayer1;
    @FXML
    private Button setPlayer2;
    @FXML
    private Button setPlayer3;
    @FXML
    private Button setPlayer4;

    private Game game;

    private String set = null;

    private GameCard[] cards;
    private ImageView[] cardPositions;

    ScreenController controller;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setClicked(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String btnId = btn.getId();
        System.out.println(btnId);
//        System.out.println(event.getSource().equals(setPlayer2));
//        if(event.getSource().equals(setPlayer2)){
//            System.out.println("player2");
//        }
    }

    public void cardClicked(MouseEvent event) {
        ImageView card = (ImageView) event.getSource();
        String cardId = card.getId();
        System.out.println(cardId);
//        String id = event.getSource().toString();
//        id = id.substring(13, id.length() - 1);
//        System.out.println(id);
        if (set == null) {
            System.out.println("Card clicked - CALL SET FIRST!");
        } else {
            //TODO
        }

    }

    public void initGame(ActionEvent event) {
        String imgPath = null;
        Image img = null;
        cardPositions = new ImageView[16];
        cards = new GameCard[16];

        cardPositions[0] = card1;
        cardPositions[1] = card2;
        cardPositions[2] = card3;
        cardPositions[3] = card4;
        cardPositions[4] = card5;
        cardPositions[5] = card6;
        cardPositions[6] = card7;
        cardPositions[7] = card8;
        cardPositions[8] = card9;
        cardPositions[9] = card10;
        cardPositions[10] = card11;
        cardPositions[11] = card12;
        cardPositions[12] = card13;
        cardPositions[13] = card14;
        cardPositions[14] = card15;
        cardPositions[15] = card16;

        for (int i = 0; i < 12; i++) {
            cards[i] = game.pickCard();
            System.out.println(cards[i]);
        }

        for (int i = 0; i < 12; i++) {
            imgPath = cards[i].getImagePath();
            img = new Image(Set.class.getResourceAsStream(imgPath));
            cardPositions[i].setImage(img);
        }

        checkForSet();
    }

    public boolean checkForSet() {

        for (int ai = 0; ai < cards.length; ai++) {
            GameCard a = cards[ai];
            for (int bi = ai + 1; bi < cards.length; bi++) {
                GameCard b = cards[bi];
                for (int ci = bi + 1; ci < cards.length; ci++) {
                    GameCard c = cards[ci];
                    if(a != null && b != null && c != null){
                      if (isSet(a, b, c)) {
                        return true;
                        }   
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isSet(GameCard c1, GameCard c2, GameCard c3){
                if (!((c1.getNumber()) == c2.getNumber()) && (c2.getNumber() == c3.getNumber()) ||
                (c1.getNumber() != c2.getNumber()) && (c1.getNumber() != c3.getNumber()) && (c2.getNumber() != c3.getNumber())) {
            return false;
        }
        if (!((c1.getSymbol() == c2.getSymbol()) && (c2.getSymbol() == c3.getSymbol()) ||
                (c1.getSymbol() != c2.getSymbol()) && (c1.getSymbol() != c3.getSymbol()) && (c2.getSymbol()!= c3.getSymbol()))) {
            return false;
        }
        if (!((c1.getPadding() == c2.getPadding()) && (c2.getPadding() == c3.getPadding()) ||
                (c1.getPadding() != c2.getPadding()) && (c1.getPadding() != c3.getPadding()) && (c2.getPadding() != c3.getPadding()))) {
            return false;
        }
        if (!((c1.getColour() == c2.getColour())) && (c2.getColour() == c3.getColour()) ||
                (c1.getColour() != c2.getColour()) && (c1.getColour() != c3.getColour()) && (c2.getColour() != c3.getColour())) {
            return false;
        }
        System.out.println("Set detected!");
        return true;
    }

    public GameController() {
        game = new Game();
        game.generateCards("oval", "rectangle", "wave", "red", "green", "blue");
        game.shuffleCards();
    }

    public void goToMain(ActionEvent event) {
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
