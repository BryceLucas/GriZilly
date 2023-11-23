package grizilly;

import java.util.ArrayList;
import java.util.List;

class MusicLibrary {
    private List<Song> songs;

    public MusicLibrary() {
        this.songs = new ArrayList<>();
        LoadSongs();
    }

    private void LoadSongs() {
        songs.add(new Song("path", "title", "artist", 60));
        // Add more songs as needed (dont know if this will automate)
    }

    public List<Song> getAllSongs() {
        return songs;
    }

    public List<Song> createAllSongsPlaylist() {
        return new ArrayList<>(songs);
    }
}

public class MusicPlaylist extends Playlist {
    public static void main(String[] args) {
        MusicLibrary musicLibrary = new MusicLibrary();
        List<Song> allSongsPlaylist = musicLibrary.createAllSongsPlaylist();
        System.out.println("All Songs Playlist:");
        for (Song song : allSongsPlaylist) {
            System.out.println(song);
        }
    }
}