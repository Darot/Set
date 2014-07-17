/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.model;

import java.util.Arrays;
import interfaces.model.Cards;

/**
 * This is the card model it contains all information about a card.
 * 
 * @author Sebastian Neiss 
 */
public class GameCard implements Cards {

    //Konstants
    public static final String[] colours = {"red", "green", "blue"};
    public static final String[] paddings = {"open", "solid", "striped"};
    public static final String[] symbols = {"oval", "rectangle", "wave"};

    private boolean selected = false;
    private String colour = null;
    private String padding = null;
    private String symbol = null;
    private int number = 0;

    public GameCard(String colour, String padding, String symbol, int number) {
        this.colour = colour;
        this.padding = padding;
        this.symbol = symbol;
        this.number = number;
    }

    /**
     * this method is not used anymore. (ToDo: Delete!?)
     * @return selected
     */
    @Override
    public boolean isSelected() {
        return selected;
    }

    /**
     * this method is not used anymore. (ToDo: Delete!?)
     * @param selected (true / false)
     */
    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return colour
     */
    @Override
    public String getColour() {
        return colour;
    }

    @Override
    public void setColour(String colour) {
        if (Arrays.asList(colours).contains(colour)) {
            this.colour = colour;
        }
    }

    /**
     * @return padding
     */
    @Override
    public String getPadding() {
        return padding;
    }

    @Override
    public void setPadding(String padding) {
        if (Arrays.asList(paddings).contains(padding)) {
            this.padding = padding;
        }
    }

    /**
     * @return symbol
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public void setSymbol(String Symbol) {
        if (Arrays.asList(symbols).contains(symbol)) {
            this.symbol = symbol;
        }
    }

    /**
     * @return path to card image
     */
    @Override
    public String getImagePath() {
        String path = "/resources/cards/" + colour + "-" + padding + "-" + symbol + "-" + number + ".jpg";
        System.out.println(path);
        return path;
    }

    /**
     * @return number
     */
    @Override
    public int getNumber() {
        return number;
    }

}
