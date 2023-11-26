package grizilly;

import java.util.ArrayList;

public class Library {
	ArrayList<String> directories = new ArrayList<>();
	ArrayList<Playlist> playlists = new ArrayList<>();
	// default should be the music playlist?
	Playlist currentPlaylist;
	
	//empty library
	public Library () {

	}
	
	// Creates a library with 1 directory.
	public Library(String firstDir) {
		addDirectory(firstDir);
		createSpecialPlaylists();
	}

	public void addDirectory(String path) {
		directories.add(path);
		createSpecialPlaylists();
	}
	public void removeDirectory(String path) {
		directories.remove(path);
		createSpecialPlaylists();
	}
	public void printDirs() {
		for (String s : directories) {
			System.out.println(s);
		}
	}
	// will have to run this every time a new directory is added or on rescan of files in dirs
	private void createSpecialPlaylists() {
		// TODO
	}
}
