package set.model;

import java.util.Random;
import set.services.Configurator;

/**
 * This is the game model - it contains all information about the game.
 *
 * @author Sebastian Neiss / Daniel Roth
 */
public class Game {

    private GameCard[] cards;
    private int cardCounter = 0;

    public Player player1;
    public Player player2;
    public Player player3;
    public Player player4;

    /**
     * Get configurated players an initialize them
     */
    public Game() {
        Configurator configurator = new Configurator();
        configurator.loadConfiguration("src/config/config.properties");
        player1 = new Player(configurator.getPlayer1Name());
        player2 = new Player(configurator.getPlayer2Name());
        player3 = new Player(configurator.getPlayer3Name());
        player4 = new Player(configurator.getPlayer4Name());
    }

    /**
     * @return amount of left cards
     */
    public int getCardCount() {
        return cardCounter;
    }

    /**
     * @return generated cards
     */
    public GameCard[] getCards() {
        return cards;
    }

    /**
     * @return next card in the card-arrays
     */
    public GameCard pickCard() {
        cardCounter--;
        return cards[cardCounter];
    }

    /**
     * Initializes all GameCards with the symbols the client has chosen.
     */
    public void generateCards(String symbol1, String symbol2, String symbol3, String colour1, String colour2, String colour3) {
        cards = new GameCard[81];
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
                        cardCounter++;
                    }
                }

            }
        }
        System.out.println(cardCounter);
    }

    /**
     * Initializes all GameCards with the symbols the client has chosen (for only one color).
     */
    public void generateCards(String symbol1, String symbol2, String symbol3, String colour) {
        cards = new GameCard[27];
        String[] symbols = {symbol1, symbol2, symbol3};
        String[] shadings = {"open", "solid", "striped"};

        GameCard card;
        int cardNr = 0;

        for (int i = 0; i <= symbols.length - 1; i++) { // 3 loops for symbols
            for (int j = 0; j <= 2; j++) { //3 loops for shadings
                for (int l = 0; l <= 2; l++) {//3 loops for numbers
                    card = new GameCard(colour, shadings[j], symbols[i], l + 1);
                    cards[cardNr] = card;
                    cardNr++;
                    cardCounter++;
                }
            }
        }
        System.out.println(cardCounter);
    }

    /**
     * this method is used to shuffle the cards.
     */
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

    /**
     * Adds the count of the cards on the table (used for saving the game).
     * @param count 
     */
    public void addCardCounter(int count) {
        cardCounter = cardCounter + count;
    }
}
