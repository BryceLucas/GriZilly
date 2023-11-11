package grizilly;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class ReadMP3Metadata {
    public static void main(String[] args) {
        try {
            // Replace this with the path of MP3 file
            String mp3FilePath = "path/to/the/file.mp3";

            // Read MP3 file
            AudioFile audioFile = AudioFileIO.read(new File(mp3FilePath));
            
            // Get the tag (metadata) from the MP3 file
            Tag tag = audioFile.getTag();

            
            System.out.println("Title: " + tag.getFirst(FieldKey.TITLE));
            System.out.println("Artist: " + tag.getFirst(FieldKey.ARTIST));
            System.out.println("Album: " + tag.getFirst(FieldKey.ALBUM));
            System.out.println("Year: " + tag.getFirst(FieldKey.YEAR));
            System.out.println("Genre: " + tag.getFirst(FieldKey.GENRE));

            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

