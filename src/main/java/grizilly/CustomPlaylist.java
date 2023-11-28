package grizilly;

import java.util.ArrayList;

public class CustomPlaylist extends Playlist {
	public CustomPlaylist(String name) {
		this.songList = new ArrayList<Song>();
		this.nameOfPlaylist = name;
	}
}