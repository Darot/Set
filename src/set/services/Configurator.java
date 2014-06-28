/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Daniel Roth
 */
public class Configurator {

    //names

    private String player1Name = "Tobias";
    private String player2Name = "Hans";
    private String player3Name = "Fritz";
    private String player4Name = "Gisela";

    private String colour1 = "red";
    private String colour2 = "green";
    private String colour3 = "blue";

    private String symbol1 = "rectangel";
    private String symbol2 = "oval";
    private String symbol3 = "wave";
    //

    public void loadConfiguration(String path) {
        File configFile = new File(path);
        try {
            FileReader reader = new FileReader(configFile);
            Properties properties = new Properties();
            properties.load(reader);

            player1Name = properties.getProperty("player1Name");
            player2Name = properties.getProperty("player2Name");
            player3Name = properties.getProperty("player3Name");
            player4Name = properties.getProperty("player4Name");

            colour1 = properties.getProperty("colour1");
            colour2 = properties.getProperty("colour2");
            colour3 = properties.getProperty("colour3");

            symbol1 = properties.getProperty("symbol1");
            symbol2 = properties.getProperty("symbol2");
            symbol3 = properties.getProperty("symbol3");

        } catch (FileNotFoundException ex) {
            System.out.println("file does not exist");
        } catch (IOException ex) {
            System.out.println("I/O error!");
        }

    }

    public void writeConfiguration() {
        File configFile = new File("src/config/config.properties");
        try {
            Properties properties = new Properties();
            //Save playerames
            properties.setProperty("player1Name", player1Name);
            properties.setProperty("player2Name", player2Name);
            properties.setProperty("player3Name", player3Name);
            properties.setProperty("player4Name", player4Name);
            //Save color setup
            properties.setProperty("colour1", colour1);
            properties.setProperty("colour2", colour2);
            properties.setProperty("colour3", colour3);
            //save symbols
            properties.setProperty("symbol1", symbol1);
            properties.setProperty("symbol2", symbol2);
            properties.setProperty("symbol3", symbol3);

            FileWriter writer = new FileWriter(configFile);
            properties.store(writer, "GameSetup");
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file does not exist");
        } catch (IOException ex) {
            System.out.println("I/O error!");
        }
    }

    /**
     * @return the player1Name
     */
    public String getPlayer1Name() {
        return player1Name;
    }

    /**
     * @param player1Name the player1Name to set
     */
    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    /**
     * @return the player2Name
     */
    public String getPlayer2Name() {
        return player2Name;
    }

    /**
     * @param player2Name the player2Name to set
     */
    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    /**
     * @return the player3Name
     */
    public String getPlayer3Name() {
        return player3Name;
    }

    /**
     * @param player3Name the player3Name to set
     */
    public void setPlayer3Name(String player3Name) {
        this.player3Name = player3Name;
    }

    /**
     * @return the player4Name
     */
    public String getPlayer4Name() {
        return player4Name;
    }

    /**
     * @param player4Name the player4Name to set
     */
    public void setPlayer4Name(String player4Name) {
        this.player4Name = player4Name;
    }

    /**
     * @return the colour1
     */
    public String getColour1() {
        return colour1;
    }

    /**
     * @param colour1 the colour1 to set
     */
    public void setColour1(String colour1) {
        this.colour1 = colour1;
    }

    /**
     * @return the colour2
     */
    public String getColour2() {
        return colour2;
    }

    /**
     * @param colour2 the colour2 to set
     */
    public void setColour2(String colour2) {
        this.colour2 = colour2;
    }

    /**
     * @return the colour3
     */
    public String getColour3() {
        return colour3;
    }

    /**
     * @param colour3 the colour3 to set
     */
    public void setColour3(String colour3) {
        this.colour3 = colour3;
    }

    /**
     * @return the symbol1
     */
    public String getSymbol1() {
        return symbol1;
    }

    /**
     * @param symbol1 the symbol1 to set
     */
    public void setSymbol1(String symbol1) {
        this.symbol1 = symbol1;
    }

    /**
     * @return the symbol2
     */
    public String getSymbol2() {
        return symbol2;
    }

    /**
     * @param symbol2 the symbol2 to set
     */
    public void setSymbol2(String symbol2) {
        this.symbol2 = symbol2;
    }

    /**
     * @return the symbol3
     */
    public String getSymbol3() {
        return symbol3;
    }

    /**
     * @param symbol3 the symbol3 to set
     */
    public void setSymbol3(String symbol3) {
        this.symbol3 = symbol3;
    }
}
