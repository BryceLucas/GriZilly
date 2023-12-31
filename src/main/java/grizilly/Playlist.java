package grizilly;
import gui.TTest;
import java.util.ArrayList;
import gui.AudioPlayer;
public abstract class Playlist {
	// i think its fair to start these as false. spotify does
	boolean shuffle = false;
	boolean repeat = false;

	public String nameOfPlaylist;
	AudioPlayer audioPlayer;
	// for songList field, we might need to make a new class to be that songlist
	// because for example, the music playlist is easy, its just a list of songs,
	// but artist is more complicated, would need to group artists up and then list each song under an artist
	ArrayList<Song> songList;
	public Song currentSong;

	public void toggleShuffle() {
		if (repeat == false) {
			repeat = true;
		} else {
			repeat = true;
		}
	}
	public void toggleRepeat() {
		if (shuffle == false) {
			shuffle = true;
		} else {
			shuffle = true;
		}
	}
	public ArrayList<TTest> giveNameArray() {
		ArrayList<TTest> x = new ArrayList<>();
		for (Song s : songList) {
			x.add(new TTest(s.title, s.artist));
		}
		return x;
	}
	public ArrayList<TTest> giveArtistArray() {
		ArrayList<TTest> x = new ArrayList<>();
		for (Song s : songList) {
			x.add(new TTest(s.title, s.artist));
		}
		return x;
	}
	public void addSong(Song song) {
		songList.add(song);

		if (songList.size() == 1) {
			setCurrentSong(song);
		}

		// the first song you add to the music playlist becomes the default song it will play
		// guarentees if there are songs in the playlist, the audiplayer will not be empty
		createAudioPlayer();
	}
	public void deleteSong(Song song) {
		songList.remove(song);
	}
	public void setCurrentSong(Song song) {
		currentSong = song;
	}

	public void play() {
		audioPlayer.playAudio();
	}
	public void pause() {
		audioPlayer.pauseAudio();
	}
	// autoplays the next/last  song
	public void back() {
		int index = songList.indexOf(currentSong);

		// checking if going back would cause OOB error
		if (index > 0) {
			audioPlayer.pauseAudio();
			audioPlayer = new AudioPlayer(songList.get(index - 1).absolutePath);
			currentSong = songList.get(index - 1);
			play();
		} else {
			System.out.println("Back failed: index - 1 is OOB");
		}
	}
	public void next() {
		int index = songList.indexOf(currentSong);

		// checking if going forward would cause OOB error
		if (index + 1 < songList.size()) {
			audioPlayer.pauseAudio();
			audioPlayer = new AudioPlayer(songList.get(index + 1).absolutePath);
			currentSong = songList.get(index + 1);
			play();
		} else {
			System.out.println("Forward failed: index "+ index + " + 1 is OOB");
		}
	}
	public void setVolume(double volume) {
		audioPlayer.setVolume(volume);
	}
	private void createAudioPlayer() {
		audioPlayer = new AudioPlayer(currentSong.absolutePath);
	}
}
