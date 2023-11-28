package grizilly;

import java.util.ArrayList;

public class Library {
	ArrayList<String> directories = new ArrayList<>();
	ArrayList<Playlist> specialPlaylists = new ArrayList<>();
	public ArrayList<Playlist> customPlaylists = new ArrayList<>();
	// default should be the music playlist?
	public Playlist currentPlaylist;
	
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
		// music playlist

		if (specialPlaylists.isEmpty()) {
			musicPlaylistBuilder builder = new musicPlaylistBuilder();
			// this .get(0) makes it so it only works with 1 directory. stuff probably wont work with more than 1
			specialPlaylists.add(builder.createPlaylist(directories.get(0)));
		} else {
			// removes music playlist and makes a new one
			musicPlaylistBuilder builder = new musicPlaylistBuilder();
			specialPlaylists.remove(0);
			specialPlaylists.add(builder.createPlaylist(directories.get(0)));
		}

		// sets the music playlist to current playlist upon creation of specials
		// this is okay because rn we only do this once.
		setCurrentPlaylist(specialPlaylists.get(0));
	}

	private void setCurrentPlaylist(Playlist playlist) {
		this.currentPlaylist = playlist;
	}

	public void createCustomPlaylist(String name) {
		customPlaylists.add(new CustomPlaylist(name));
	}
}
