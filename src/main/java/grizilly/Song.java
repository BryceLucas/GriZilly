package grizilly;

public class Song {
    private String title;
    private String artist;
    private String album;
    private String year;
    private String genre;
    private String absolutePath;  // Assuming this is the file path of the song
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
        return title + " by " + artist + " on album " + album + " [" + year + ", " + genre + ", " + lengthInSeconds + " seconds]";
    }
}