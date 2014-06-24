/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.model;

import java.util.Random;

/**
 *
 * @author zeus
 */
public class Game {

    private GameCard[] cards = new GameCard[81];
    private int cardCounter = 80;
    
    public Player player1;
    public Player player2;
    public Player player3;
    public Player player4;

    public Game() {
        player1 = new Player("Tobias");
        player2 = new Player("Tobias");
        player3 = new Player("Tobias");
        player4 = new Player("Tobias");
    }

    public int getCardCount(){
        return cardCounter;
    }
    
    public GameCard[] getCards() {
        return cards;
    }

    public GameCard pickCard() {
        cardCounter--;
        return cards[cardCounter];
    }

    //Initializes all GameCards with the symbols with the setup, the client has chosen.
    public void generateCards(String symbol1, String symbol2, String symbol3, String colour1, String colour2, String colour3) {
        String[] symbols = {symbol1, symbol2, symbol3};
        String[] colours = {colour1, colour2, colour3};
        String[] shadings = {"open", "solid", "striped"};

        GameCard card;
        int cardNr = 0;

        for (int i = 0; i <= symbols.length - 1; i++) { // 3 loops for symbols
            for (int k = 0; k <= colours.length - 1; k++) { // 3 loops for colours
                for (int j = 0; j <= 2; j++) { //3 loops for shadings
                    for (int l = 0; l <= 2; l++) {//3 loops for numbers
                        card = new GameCard(colours[k], shadings[j], symbols[i], l + 1);
                        cards[cardNr] = card;
                        cardNr++;
                    }
                }

            }
        }
    }

    //this method is used du shuffle the cards
    public void shuffleCards() {
        Random rnd = new Random();

        for (int i = cards.length - 1; i > 0; i--) {
            //simply swap cards
            int index = rnd.nextInt(i + 1);
            GameCard rndCard = cards[index];
            cards[index] = cards[i];
            cards[i] = rndCard;
        }
    }
}
