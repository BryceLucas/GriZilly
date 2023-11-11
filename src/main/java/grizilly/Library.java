package grizilly;
import java.util.ArrayList;

public class Library {
	ArrayList<String> directories = new ArrayList<>();
	ArrayList<Playlist> playlists = new ArrayList<>();
	// default should be the music playlist?
	Playlist currentPlaylist;
	
	// this one will be the first library you create on first time opening the program
	public Library() {

	}
	// this one will read a file (JSON? or some other kind)
	// to create the library. lets you save your directories and such
	public Library(String pathToJSON) {
		// TODO
	}

	public void addDirectory(String path) {
		directories.add(path);
	}
	public void removeDirectory(String path) {
		directories.remove(path);
	}
	// will have to run this every time a new directory is added or on rescan of files in dirs
	private void createSpecialPlaylists() {
		// TODO
	}
}
