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
        // Assume you have a method to populate the library (e.g., loadSongsFromDatabase())
        loadSongsFromDatabase();
    }

    private void loadSongsFromDatabase() {
        // Populate the library with songs from the local database or file system
        // You might need to replace this with your actual logic for loading songs
        songs.add(new Song("Song1", "Artist1"));
        songs.add(new Song("Song2", "Artist2"));
        // Add more songs as needed (dont know if this will automate)
    }

    public List<Song> getAllSongs() {
        return songs;
    }

    // Other methods to manage the music library

    // Example method to create a playlist with all songs
    public List<Song> createAllSongsPlaylist() {
        return new ArrayList<>(songs);
    }
}

public class MusicApp {
    public static void main(String[] args) {
        // Create an instance of the MusicLibrary
        MusicLibrary musicLibrary = new MusicLibrary();

        // Create a playlist with all songs
        List<Song> allSongsPlaylist = musicLibrary.createAllSongsPlaylist();

        // Display the playlist
        System.out.println("All Songs Playlist:");
        for (Song song : allSongsPlaylist) {
            System.out.println(song);
        }
    }
}
