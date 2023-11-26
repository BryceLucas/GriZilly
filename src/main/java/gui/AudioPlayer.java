package gui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioPlayer {
	String path;
	MediaPlayer player;

	public AudioPlayer(String path) {
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
}