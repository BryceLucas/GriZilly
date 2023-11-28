package gui;

import java.io.File;
import java.net.URI;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.scene.media.AudioEqualizer;

public class AudioPlayer {
    String path;
    MediaPlayer player;

    public AudioPlayer(String path) {
        this.path = path;
        File f = new File(path);
        URI u = f.toURI();
        this.path = u.toString();

        Media media = new Media(this.path);
        player = new MediaPlayer(media);
    }

    public void playAudio() {
        if (player.getStatus() == Status.PAUSED) {
            player.play();
        } else {
            player.play();
        }
    }

    public void pauseAudio() {
        player.pause();
    }

    public void stopAudio() {
        player.stop();
    }

    public void setVolume(double volume) {
        player.setVolume(volume);
    }

    public double getVolume() {
        return player.getVolume();
    }

    public void mute() {
        player.setMute(true);
    }

    public void unmute() {
        player.setMute(false);
    }
}
