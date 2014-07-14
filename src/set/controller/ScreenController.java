
package set.controller;


import interfaces.controller.ControlledScreen;
import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * This is the Screen controller witch generates and controls
 * our stack-pane.
 * 
 * @author Daniel Roth
 */
public class ScreenController extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();

    /**
     * Stores a screen to the HashMap.
     * 
     * @param name
     * @param screen 
     */
    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }
    
    
    /**
     * A Getter method that is actually not used but i thought it could
     * be useful anytime.
     * 
     * @param name
     * @return loaded screen
     */
    public Object getScreen(String name){
        return screens.get(name);
    }

    /**
     * Loads a screen, initializes it and stores it into a HashMap.
     * 
     * @param name (of the screen)
     * @param resource (FXML Path)
     * @return true / false
     */
    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler
                    = ((ControlledScreen) myLoader.getController());
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong! Check your controller -classes!!! \n "
                    + "Are all handlers used in FXML defined?");
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method tries to display the screen with a predefined name
     * if it is already loaded.
     * 
     * @param screenname
     * @return true / false
     */
    public boolean setScreen(final String name) {
        if (screens.get(name) != null) { //screen loaded
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) { //if there is more than one screen
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                getChildren().remove(0); //remove the displayed screen
                                getChildren().add(0, screens.get(name)); //add the screen
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(screens.get(name)); //no one else been displayed, then just show
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            System.out.println(screens.get("configuration"));
            return false;
        }
    }
    
    
    /**
     * This method simply removes a screen from the hashmap and reports the status of this 
     *operation
     */ 
    public boolean unloadScreen(String name) {
        if(screens.remove(name) ==  null){
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }

}
