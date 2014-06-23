/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.controller;

import interfaces.controller.ControlledScreen;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import set.Set;
import set.model.Game;
import set.model.GameCard;
import set.model.Player;

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

    private int set = -1;

    private GameCard[] cards;
    private ImageView[] cardPositions;
    private GameCard[] selectedCards = new GameCard[3];
    private int cardCounter = 0;
    private Player players[] = new Player[4];

    ScreenController controller;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public GameController() {
        game = new Game();
        game.generateCards("oval", "rectangle", "wave", "red", "green", "blue");
        game.shuffleCards();
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
        
        players[0] = game.player1;
        players[1] = game.player2;
        players[2] = game.player3;
        players[3] = game.player4;
    }

    public void setClicked(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String playerId = btn.getId();
        System.out.println(playerId);
        if (set == -1) {
            playerId = playerId.substring(9);
            int Id = Integer.parseInt(playerId);
            System.out.println(Id);
            set = Id;
        }
    }

    public void cardClicked(MouseEvent event) {

        if (set != -1) {
            ImageView card = (ImageView) event.getSource();
            String cardId = card.getId();
            cardId = cardId.substring(4);
            int Id = Integer.parseInt(cardId);
            selectedCards[cardCounter] = cards[Id];
            cardCounter++;
        

        if (cardCounter == 3) {
            if (isSet(selectedCards[0], selectedCards[1], selectedCards[2]) == true) {
                System.out.println("SET!");
                addPoint(set);
            }
            cardCounter = 0;
            Arrays.fill(selectedCards, null);
            set = -1;
        }

        System.out.println(selectedCards[0]);
        System.out.println(selectedCards[1]);
        System.out.println(selectedCards[2]);
        
        }else {
            System.out.println("SET has to be klicked first!");
        }
    }
    
    public void removeUsedCards(GameCard c1, GameCard c2, GameCard c3){
        
    }
    
    public void addPoint(int playerId){
        System.out.println(playerId);
        players[playerId].addPoint();
        Label label = (Label)  controller.lookup("#player" + playerId + "Points");
        label.setText("" + players[playerId].getPoints());
    }

    public boolean checkForSet() {

        for (int ai = 0; ai < cards.length; ai++) {
            GameCard a = cards[ai];
            for (int bi = ai + 1; bi < cards.length; bi++) {
                GameCard b = cards[bi];
                for (int ci = bi + 1; ci < cards.length; ci++) {
                    GameCard c = cards[ci];
                    if (a != null && b != null && c != null) {
                        if (isSet(a, b, c)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isSet(GameCard c1, GameCard c2, GameCard c3) {
        
        if (!((c1.getNumber() == c2.getNumber()) && (c2.getNumber() == c3.getNumber())
                || (c1.getNumber() != c2.getNumber()) && (c1.getNumber() != c3.getNumber()) && (c2.getNumber() != c3.getNumber()))) {
            return false;
        }
        if (!((c1.getSymbol() == c2.getSymbol()) && (c2.getSymbol() == c3.getSymbol())
                || (c1.getSymbol() != c2.getSymbol()) && (c1.getSymbol() != c3.getSymbol()) && (c2.getSymbol() != c3.getSymbol()))) {
            return false;
        }
        if (!((c1.getPadding() == c2.getPadding()) && (c2.getPadding() == c3.getPadding())
                || (c1.getPadding() != c2.getPadding()) && (c1.getPadding() != c3.getPadding()) && (c2.getPadding() != c3.getPadding()))) {
            return false;
        }
        if (!((c1.getColour() == c2.getColour()) && (c2.getColour() == c3.getColour())
                || (c1.getColour() != c2.getColour()) && (c1.getColour() != c3.getColour()) && (c2.getColour() != c3.getColour()))) {
            return false;
        }
        System.out.println("Set detected!");
        return true;
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
