package grizilly;

public class Song {
    public String title;
    String artist;
    String album;
    String year;
    String genre;
    String absolutePath;  // Assuming this is the file path of the song
    private int lengthInSeconds;  

    public Song(String absolutePath, String title, String artist, String album, String year, String genre, int lengthInSeconds) {
        this.absolutePath = absolutePath;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.genre = genre;
        this.lengthInSeconds = lengthInSeconds;
    }

    

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}