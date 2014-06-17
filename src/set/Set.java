/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package set;

import set.controller.ScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author zeus
 */
public class Set extends Application {
    
    //View Configuration
    public static final String PATH_PREFIX ="/set/view/";
    
    public static final String SPLASH_SCREEN = "splash";
    public static final String SPLASH_SCREEN_FXML = PATH_PREFIX + "splash.fxml";
    public static final String MAIN_MENU =  "main";
    public static final String MAIN_MENU_FXML = PATH_PREFIX + "mainMenu.fxml";
    public static final String CONFIGURATION_MENU =  "configuationMenu";
    public static final String CONFIGURATION_MENU_FXML = PATH_PREFIX + "configurationMenu.fxml";
    public static final String LOAD_GAME = "loadGame";
    public static final String LOAD_GAME_FXML = PATH_PREFIX + "loadGame.fxml";
    public static final String GAME = "game";
    public static final String GAME_FXML = PATH_PREFIX + "game.fxml";
    public static final String WINNER = "winner";
    public static final String WINNER_FXML = PATH_PREFIX + "winner.fxml";
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        ScreenController mainContainer = new ScreenController();
        mainContainer.loadScreen(Set.SPLASH_SCREEN, Set.SPLASH_SCREEN_FXML);
        mainContainer.loadScreen(Set.MAIN_MENU, Set.MAIN_MENU_FXML);
        mainContainer.loadScreen(Set.CONFIGURATION_MENU, Set.CONFIGURATION_MENU_FXML);
        mainContainer.loadScreen(Set.LOAD_GAME, Set.LOAD_GAME_FXML);
        mainContainer.loadScreen(Set.GAME, Set.GAME_FXML);
        mainContainer.loadScreen(Set.WINNER, Set.WINNER_FXML);
        
        mainContainer.setScreen(Set.SPLASH_SCREEN);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/set/view/splash.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
