package gui;

import java.io.File;
import java.net.URI;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioPlayer {
	String path;
	MediaPlayer player;

	public AudioPlayer(String path) {
		// ugly. could fix this in the musicPlaylistBuilder.java file
		// has to be done because in a valid URI, the first : character needs to go after the format.
		File f = new File(path);
		URI u = f.toURI();
		path = u.toString();
		this.path = path;
		
		Media media = new Media(path);
		player = new MediaPlayer(media);
	}
	public void playAudio() {
		player.play();
	}
	public void pauseAudio() {
		player.pause();
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