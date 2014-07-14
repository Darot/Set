
package set.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import set.model.SoundPlayer;

/**
 * FXML Controller class
 *
 * @author Sebastian Neiss
 */
public class WinnerController implements Initializable {

    ScreenController controller;
    
    @FXML
    Label winner;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void setScreenParent(ScreenController screenParent) {
        controller = screenParent;
    }
    
    /**
     * This method is used to inject data from other controllers
     * like the game controller. 
     * The information about the winner(s) will be injected here.
     * 
     * @param winners 
     */
    public void initData (String[] winners){
       String winnerText = "";
        for(int i = 0; i < winners.length; i++){
           if(winners[i] != null){
               winnerText = winnerText + winners[i] + "\n";
           }
        }
        winner.setText(winnerText);
        
    }
    
}
