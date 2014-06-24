/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.model;

import java.net.URL;
import javafx.scene.media.AudioClip;

/**
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
