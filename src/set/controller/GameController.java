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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import set.Set;
import set.model.Game;
import set.model.GameCard;
import set.model.Player;
import set.model.SoundPlayer;

/**
 * FXML Controller class
 *
 * @author zeus
 */
public class GameController implements Initializable, ControlledScreen {

    /*
    Inject JavaFX Frontend Objects for later manipulation
    */
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
    
    @FXML
    private Button start;
    @FXML 
    private Label cardCount;

    private Game game;

    private int set = -1;

    private GameCard[] cards;
    private ImageView[] cardPositions;
    private int[] selectedCards = new int[3]; //selected cards for a SET
    private int cardCounter = 0; //Card counter for set selection
    private Player players[] = new Player[4];

    ScreenController controller;
    SoundPlayer soundPlayer = new SoundPlayer();

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

    /**
     *      EVENTHANDLER
     */
    
    //Prepare everything for a Game 
    public void initGame(ActionEvent event) throws Exception {
        String imgPath = null;
        Image img = null;
        cardPositions = new ImageView[16];
        cards = new GameCard[16];

        //ImageViews (indexes equal to cards[])
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

        //pick the first 12 cards 
        for (int i = 0; i < 12; i++) {
            cards[i] = game.pickCard();
            System.out.println(cards[i]);
        }

        //display picked cards in the ImageViews
        for (int i = 0; i < 12; i++) {
            imgPath = cards[i].getImagePath();
            img = new Image(Set.class.getResourceAsStream(imgPath));
            cardPositions[i].setImage(img);
        }

        //if there is no SET, pick cards until there is a SET
        if(checkForSet() == false){
            addCards(1);
        }

        //safe players in array -> used later
        players[0] = game.player1;
        players[1] = game.player2;
        players[2] = game.player3;
        players[3] = game.player4;

        //desable start button to prevent another initialisation
        start.setDisable(true);
        //initialize sound model
        soundPlayer.playCardSound();
        cardCount.setText("" + game.getCardCount());
    }

    /*
    This method sets the set variable to the players id who klicke SET
    if no other player klicked fist
    */
    public void setClicked(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String playerId = btn.getId();

        if (set == -1) {
            playerId = playerId.substring(9);
            int Id = Integer.parseInt(playerId);
            set = Id;
        }
    }

    /*
    This method handles the card selection for a SET after the SET button was klicked
    */
    public void cardClicked(MouseEvent event) throws Exception{

        if (set != -1) { //Set has to be 1 , 2, 3 , 4 for the playerIDs
            //get the card and store it in selectedCards[]
            ImageView card = (ImageView) event.getSource();
            String cardId = card.getId();
            cardId = cardId.substring(4);
            int Id = Integer.parseInt(cardId);
            selectedCards[cardCounter] = Id;
            cardCounter++;

            //if this Card selection was the third check for correctnes
            if (cardCounter == 3) { 
                if (isSet(cards[selectedCards[0]], cards[selectedCards[1]], cards[selectedCards[2]]) == true) {
                    addPoint(set);
                    soundPlayer.playPointSound();
                    removeUsedCards(selectedCards[0], selectedCards[1], selectedCards[2]);
                    addCards(checkFreePositions());
                } else {
                    soundPlayer.playFailSound();
                }
                //reset values for next SET
                cardCounter = 0;
                set = -1;
                //if there are no SETs add cards until there is one
                while(checkForSet() == false && game.getCardCount() != 0){
                    addCards(1);
                }
            }

        } else {
            //SET has to be clicked before a card can be selected
            System.out.println("SET has to be klicked first!");
        }
    }

    /**
     *      GAMEMANAGEMENT
     */
    
    /*
    This method removes all cards after they have been use for a Set
    */
    public void removeUsedCards(int pos1, int pos2, int pos3) {
        //Remove the Images from the view
        String imgPath = "/resources/cards/card-back.jpg";
        Image img = new Image(Set.class.getResourceAsStream(imgPath));
        cardPositions[pos1].setImage(img);
        cardPositions[pos2].setImage(img);
        cardPositions[pos3].setImage(img);
        //Remove the cards from cards-array    
        cards[pos1] = null;
        cards[pos2] = null;
        cards[pos3] = null;
    }

    /*
    Adds Cards to the View if there are Cards left (81)
    */
    public void addCards(int amount) throws Exception{
        //if there are no cards left -> Game is over!
        if(game.getCardCount() == 0){
            gameEnd();
        }
        //prevent from picking more cards than cards are left
        if(amount >= game.getCardCount()) {
            amount = game.getCardCount();
        }
        //pick cards an display in the view
        String imgPath;
        Image img;
        for (int i = 0; amount > 0; i++) {
            if (cards[i] == null) {
                cards[i] = game.pickCard();
                imgPath = cards[i].getImagePath();
                img = new Image(Set.class.getResourceAsStream(imgPath));
                cardPositions[i].setImage(img);
                amount--;
            }
        }
        //refresh the cardcounter in view
        cardCount.setText("" + game.getCardCount());
    }

    /*
    Adds a point if a player found a SET
    */
    public void addPoint(int playerId) {
        players[playerId].addPoint();
        Label label = (Label) controller.lookup("#player" + playerId + "Points");
        //Refresh Scoreboard
        label.setText("" + players[playerId].getPoints());
    }

    /*
    Loops through all displayed cards an checks if there is a SET
    */
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
    
    /*
    Retruns the number of free positions for cards
    */
    public int checkFreePositions(){
        int freePositions = 0;
        int lockedPositions = 0;
        
        for(int i = 0; i < 16; i++){
            if(cards[i] != null){
                lockedPositions ++;
            }
        }
        
        freePositions = 12 - lockedPositions;
        if(freePositions < 0){
            freePositions = 0;
        }
        System.out.println(freePositions);
        return freePositions;
    }
    
    /*
    Checks if the given cards are a SET
    */
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

    
     /**
     *      NAVIGATION
     */
    public void goToMain(ActionEvent event) {
        controller.setScreen(Set.MAIN_MENU);
    }

    public void gameEnd() throws Exception {
        //Find winner(s)
        String[] winners = new String[4];
        int wCount = 0;
        int max = 0;
        for (int i = 0; i <= 3; i++) {
            if (players[i].getPoints() > max) {
                winners[0] = players[i].getName();
                max = players[i].getPoints();
                wCount = 1;
                winners[1] = null;
                winners[2] = null;
                winners[3] = null;
            }else if (players[i].getPoints() == max) {
                winners[wCount] = players[i].getName();
                wCount++;
            }
        }

        //Create new View (new Window)
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Set.WINNER_FXML));

        Stage stage = new Stage();
        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );
        
        //Get the controller of the winnerscreen
        WinnerController winController = loader.<WinnerController>getController();
        stage.show();
        //Inject Dependencies (winnernames)
        winController.initData(winners);
        soundPlayer.playApplouseSound();
        
        //Reload gameview to be able to start a new game an let garbage collector
        //remove unused gameobjects
        controller.setScreen(Set.MAIN_MENU);
        controller.unloadScreen(Set.GAME);
        controller.loadScreen(Set.GAME, Set.GAME_FXML);
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
