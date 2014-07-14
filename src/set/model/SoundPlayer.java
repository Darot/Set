
package set.model;

import java.net.URL;
import javafx.scene.media.AudioClip;

/**
 * This class provides sounds.
 * Every method will play a sound when called.
 * 
 * @author daniel
 */
public class SoundPlayer {

    public void playCardSound() {
        final URL resource = getClass().getResource("/resources/sounds/cardPlace1.wav");
        AudioClip placeCard = new AudioClip(resource.toString());
        placeCard.play();
    }

    public void playFailSound() {
        final URL resource = getClass().getResource("/resources/sounds/error.wav");
        AudioClip fail = new AudioClip(resource.toString());
        fail.play();
    }

    public void playPointSound() {
        final URL resource = getClass().getResource("/resources/sounds/point.wav");
        AudioClip point = new AudioClip(resource.toString());
        point.play();
    }

    public void playApplouseSound() {
        final URL resource = getClass().getResource("/resources/sounds/applause.wav");
        AudioClip applause = new AudioClip(resource.toString());
        applause.play();
    }

}
