package src;
public abstract class Playlist {
	// i think its fair to start these as false. spotify does
	boolean shuffle = false;
	boolean repeat = false;

	String nameOfPlaylist;
	// for songList field, we might need to make a new class to be that songlist
	// because for example, the music playlist is easy, its just a list of songs,
	// but artist is more complicated, would need to group artists up and then list each song under an artist

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
	// these two will need to be done after we decide what to do about songList
	public void addSong() {
		// TODO
	}
	public void deleteSong() {
		// TODO
	}

	public void play() {
		// TODO
	}
	public void pause() {
		// TODO
	}
	public void back() {
		// TODO
	}
	public void next() {
		// TODO
	}
}
