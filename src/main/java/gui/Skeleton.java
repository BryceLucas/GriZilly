import grizilly.Library;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Skeleton extends Application {
    public Library primLibrary;
    public Stage primStage;
    private MediaPlayer mediaPlayer; //  this adds media 

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage prim) {
        primStage = prim;
        VBox root = createSkeleton();

        Scene scene = new Scene(root, 1080, 720);
        prim.setScene(scene);
        prim.show();
    }

    private VBox createSkeleton() {
        VBox root = new VBox();
        MenuBar menuBar = menuBars();
        HBox middle = middle();
        HBox bottom = bottom();

        root.getChildren().add(menuBar);
        root.getChildren().add(middle);
        root.getChildren().add(bottom);

        return root;
    }

    private Background color(String color) {
        Background x = Background.fill(javafx.scene.paint.Paint.valueOf(color));
        return x;
    }

    private MenuBar menuBars() {
        Menu m1 = new Menu("File");
        m1.getItems().add(new MenuItem("Add directory"));
        m1.getItems().add(new MenuItem("Scan for new songs"));
        MenuBar menuBar = new MenuBar(m1);

        return menuBar;
    }

    private HBox middle() {
        HBox middle = new HBox();

        // here is the bar
        VBox playlistBar = new VBox();
        VBox.setVgrow(playlistBar, Priority.NEVER);

        ListView<String> playlistListView = new ListView<>();
       

        playlistBar.getChildren().add(playlistListView);

        // Song pane
        VBox songPane = buildSongPane();

        middle.getChildren().addAll(playlistBar, songPane);
        return middle;
    }

    private TableView<Song> buildPlaylistTable() {
        TableView<Song> playlistTable = new TableView<>();
        playlistTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Song, String> column = new TableColumn<>("Special playlists");
        playlistTable.getColumns().add(column);

        // please add songs here for testing
        Song sampleSong = new Song("path", "Sample Song", "Sample Artist", 180);
        playlistTable.getItems().add(sampleSong);

        column.setCellValueFactory(new PropertyValueFactory<>("title"));

        return playlistTable;
    }

    private VBox buildSongPane() {
        VBox songPane = new VBox();

        TableView<Song> songTable = buildPlaylistTable();
        Button playSongButton = new Button("Play");
        playSongButton.setOnAction(e -> {
            Song selectedSong = songTable.getSelectionModel().getSelectedItem();
            if (selectedSong != null) {
                playSong(selectedSong);
            }
        });

      
        Button playPauseButton = new Button("Play/Pause");
        Button nextButton = new Button("Next");
        Button prevButton = new Button("Previous");
        ProgressBar progressBar = new ProgressBar();
        Slider volumeSlider = new Slider(0, 100, 50); 

        // event handlers 
        playPauseButton.setOnAction(e -> {
            togglePlayPause();
        });

        nextButton.setOnAction(e -> {
            playNextSong();
        });

        prevButton.setOnAction(e -> {
            playPreviousSong();
        });

        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            setVolume(newValue.doubleValue());
        });

        
        HBox playbackControls = new HBox(playPauseButton, nextButton, prevButton, progressBar, volumeSlider);
        songPane.getChildren().addAll(songTable, playSongButton, playbackControls);

        return songPane;
    }

    private HBox bottom() {
        HBox bottom = new HBox();
        bottom.prefHeight(140);
        bottom.prefWidthProperty().bind(primStage.widthProperty());
        bottom.setPadding(new Insets(10));
        bottom.setBackground(color("green"));

        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button nextButton = new Button("Next");
        Button prevButton = new Button("Previous");
        ProgressBar progressBar = new ProgressBar();
        Label currentlyPlayingLabel = new Label("Now Playing: ");

        playButton.setOnAction(e -> {
            play();
        });

        pauseButton.setOnAction(e -> {
            pause();
        });

        nextButton.setOnAction(e -> {
            playNextSong();
        });

        prevButton.setOnAction(e -> {
            playPreviousSong();
        });

        
        Slider volumeSlider = new Slider(0, 100, 50); 

        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            setVolume(newValue.doubleValue());
        });

       
        HBox playbackControls = new HBox(playButton, pauseButton, nextButton, prevButton, progressBar, currentlyPlayingLabel, volumeSlider);
        bottom.getChildren().addAll(playbackControls);

        return bottom;
    }

  
    private void playSong(Song song) {
      
        System.out.println("Play button clicked for: " + song.getTitle());
    }

 
    private void togglePlayPause() {
       
        System.out.println("Play/Pause button clicked");
    }

    // Method to play the next song
    private void playNextSong() {
        
        System.out.println("Next button clicked");
    }

    // Method to play the previous song
    private void playPreviousSong() {
       
        System.out.println("Previous button clicked");
    }

    // Method to play
    private void play() {
      
        System.out.println("Play button clicked");
    }

    // Method to pause
    private void pause() {
 
        System.out.println("Pause button clicked");
    }

    // Method to set volume
    private void setVolume(double volume) {
     
        System.out.println("Volume changed: " + volume);
    }
}

class Song {
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

  

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
