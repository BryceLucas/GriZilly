package grizilly;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MusicLibraryManager {

    public static void main(String[] args) {
        String musicFolderPath = "Path_to_your_music_folder";
        String libraryFolderPath = "Path_to_your_library_folder";

        // Replace these paths with the actual paths to your music and library folders

        File musicFolder = new File(musicFolderPath);
        File libraryFolder = new File(libraryFolderPath);

        if (!musicFolder.exists() || !libraryFolder.exists()) {
            System.out.println("One or both folders do not exist. Please check your paths.");
            return;
        }

        // List music files in the music folder and copy them to the library folder
        File[] musicFiles = musicFolder.listFiles();
        if (musicFiles != null) {
            for (File musicFile : musicFiles) {
                if (musicFile.isFile() && isMusicFile(musicFile)) {
                    try {
                        Path sourcePath = musicFile.toPath();
                        Path targetPath = new File(libraryFolder, musicFile.getName()).toPath();
                        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Copied: " + musicFile.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // You can customize this method to check for specific file extensions or other criteria
    private static boolean isMusicFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".mp3") || name.endsWith(".wav") || name.endsWith(".flac");
    }
}