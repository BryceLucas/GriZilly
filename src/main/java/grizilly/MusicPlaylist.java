package grizilly;

import java.util.ArrayList;
import java.util.List;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

class MusicLibrary {
    private List<Song> songs;

    public MusicLibrary() {
        this.songs = new ArrayList<>();
        LoadSongs();
    }

    private void LoadSongs() {
        songs.add(new Song("Song1", "Artist1"));
        songs.add(new Song("Song2", "Artist2"));
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
