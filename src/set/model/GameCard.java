/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.model;

import java.util.Arrays;
import interfaces.model.Cards;

/**
 *
 * @author zeus
 */
public class GameCard implements Cards {

    //Konstants
    public static final String[] colours = {"red", "green", "blue"};
    public static final String[] paddings = {"filled", "empty", "striped"};
    public static final String[] symbols = {"star", "square", "diamond"};

    private boolean selected = false;
    private String colour = null;
    private String padding = null;
    private String symbol = null;

    public GameCard(String colour, String padding, String symbol) {
        this.colour = colour;
        this.padding = padding;
        this.symbol = symbol;
    }

    @Override
    public boolean isScelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

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

}