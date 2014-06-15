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
    
    public static final String PATH_PREFIX ="/set/view/";
    public static final String MAIN_SCREEN = "main";
    public static final String MAIN_SCREEN_FXML = PATH_PREFIX + "main.fxml";
    public static final String MAIN_MENU =  "main_menu";
    public static final String MAIN_MENU_FXML = PATH_PREFIX + "mainMenu.fxml";
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        ScreenController mainContainer = new ScreenController();
        mainContainer.loadScreen(Set.MAIN_SCREEN, Set.MAIN_SCREEN_FXML);
        mainContainer.loadScreen(Set.MAIN_MENU, Set.MAIN_MENU_FXML);
        
        mainContainer.setScreen(Set.MAIN_SCREEN);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
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
