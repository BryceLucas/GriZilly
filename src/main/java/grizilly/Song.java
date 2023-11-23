package grizilly;

public class Song {
	private String absolutePath;

    private String title;
    private String artist;
	private int lengthInSeconds;

    public Song(String absolutePath, String title, String artist, int lengthInSeconds) {
		this.absolutePath = absolutePath;

        this.title = title;
        this.artist = artist;
		this.lengthInSeconds = lengthInSeconds;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}