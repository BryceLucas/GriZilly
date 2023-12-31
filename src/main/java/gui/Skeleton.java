package gui;

import java.util.ArrayList;

import grizilly.Library;
import grizilly.Song;

import javafx.application.Application;
import javafx.beans.property.StringProperty;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Skeleton extends Application {
	public Library primLibrary;
	public Stage primStage;

	ArrayList<TTest> nameArray;
	ArrayList<TTest> artistArray;
	HBox mid;
	VBox songP;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage prim) {
		primLibrary = new Library();
		primStage = prim;
		VBox root = createSkeleton();

		Scene scene = new Scene(root, 1080, 720);
		prim.setScene(scene);
		prim.show();
	}

	private VBox createSkeleton() {
		// root that holds all, grows down
		VBox root = new VBox();
		// root.setBackground(color("black"));

		// menu bar, holds file menu on top
		MenuBar menuBar = menuBars();

		// middle pane, holds playlist bar on left, and song list on right
		HBox middle = middle();

		// bottom bar, holds the play, skip, back buttons
		HBox bottom = bottom();

		root.getChildren().add(menuBar);
		root.getChildren().add(middle);
		root.getChildren().add(bottom);

		return root;
	}

	private MenuBar menuBars() {
		Menu menu = new Menu("File");
		
	// Add directory
		// have to do this label stuff to make clicks work.. doesnt work on MenuItem
		Label l1 = new Label("Add directory");
		l1.setTextFill(Color.BLACK);
		l1.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			Stage littleWindow = new Stage();
			littleWindow.setTitle("Enter path to your music.");
			DialogPane pane = new DialogPane();

			HBox h = new HBox();
			HBox.setHgrow(h, Priority.ALWAYS);
			// doesnt seem to do anything.....
			//HBox.setMargin(h, new Insets(15));
			h.setPadding(new Insets(15));
			pane.getChildren().add(h);

			TextField typeBar = new TextField();
			typeBar.setMinWidth(250);
			
			Button finishButton = new Button("Finish");
			finishButton.setMinWidth(50);

			finishButton.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
				primLibrary.addDirectory(typeBar.getText());
				nameArray = primLibrary.currentPlaylist.giveNameArray();
				//artistArray = primLibrary.currentPlaylist.giveArtistArray();
				refreshSongTable();
				littleWindow.hide();
			});
			h.getChildren().addAll(typeBar, finishButton);

			littleWindow.setScene(new Scene(pane));
			littleWindow.show();
		});
		MenuItem menuItem = new MenuItem("", l1);
		menu.getItems().add(menuItem);
	// Scan
		Label l2 = new Label("Scan for new songs");
		l2.setTextFill(Color.BLACK);
		l2.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			refreshSongTable();
		});
		MenuItem menuItem2 = new MenuItem("", l2);
		menu.getItems().add(menuItem2);
	// Add custom playlist
		Label l3 = new Label("Create new custom Playlist");
		l3.setTextFill(Color.BLACK);
		l3.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			//primLibrary = MenuBarClicks.createNewCustomPlaylist(primLibrary);
		});
		MenuItem menuItem3 = new MenuItem("", l3);
		menu.getItems().add(menuItem3);

		MenuBar menuBar = new MenuBar(menu);
		return menuBar;
	}

	private HBox middle() {
		HBox middle = new HBox();


	// Playlist bar, holds the special playlists and customs playlists
		VBox playlistBar = new VBox();
		VBox.setVgrow(playlistBar, Priority.NEVER);
// ListView would probably be better than TableView s for these two
	// special playlists
		TableView<TTest> playlistTable = buildPlaylistTable();
	// custom playlists
		TableView<String> customPlaylistTable = buildCustomPlaylistTable();

		playlistBar.getChildren().addAll(playlistTable, customPlaylistTable);

	// will hold a list of songs that are in the playlist you are in
		VBox songPane = buildSongPane();

		middle.getChildren().addAll(playlistBar, songPane);
		
		mid = middle;
		songP = songPane;
		
		return middle;
	}
	private void refreshSongTable() {
		VBox newSongPane = buildSongPane();
		mid.getChildren().remove(songP);
		mid.getChildren().add(newSongPane);
	}

	private TableView<TTest> buildPlaylistTable() {
		TableView<TTest> playlistTable = new TableView<>();
		playlistTable.setSortPolicy(c -> false);
		playlistTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

		TableColumn<TTest, String> column = new TableColumn<>("Special playlists");
		playlistTable.getColumns().add(column);
	//this is what should show in the column 
		TTest tt = new TTest("Music", "x");
		playlistTable.getItems().add(tt);
	
	//this should be making the name show in the column
		column.setCellValueFactory(new PropertyValueFactory<TTest, String>(tt.firstNameProperty().getName()));

		return playlistTable;
	}

	private TableView<String> buildCustomPlaylistTable() {
		TableView<String> customPlaylistTable = new TableView<>();
		customPlaylistTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

		TableColumn<String, StringProperty> column2 = new TableColumn<>("Custom playlists");
		customPlaylistTable.getColumns().add(column2);
		customPlaylistTable.getItems().add("PLAYLIST TEST2222222222222222222222");

		return customPlaylistTable;
	}

	private VBox buildSongPane() {
		VBox songPane = new VBox();

		// table of songs in a playlist
		TableView<TTest> songTable = new TableView<>();
		songTable.setSortPolicy(c->false);
	// allow the songtable to be big, and to resize itself when winndow changes size
		songTable.prefHeightProperty().bind(primStage.heightProperty());
		songTable.prefWidthProperty().bind(primStage.widthProperty());

		TableColumn<TTest, String> songName = new TableColumn<>("Title");
		songName.setCellValueFactory(new PropertyValueFactory<TTest, String>("firstName"));

		TableColumn<TTest, String> songArtist = new TableColumn<>("Artist");
		songArtist.setCellValueFactory(new PropertyValueFactory<TTest, String>("artistName"));

		songTable.getColumns().addAll(songName, songArtist);
		try {
			for (TTest t : nameArray) {
				songTable.getItems().add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		songPane.getChildren().addAll(songTable);

		return songPane;
	}
	private HBox bottom() {
		HBox bottom = new HBox();
		bottom.prefHeight(140);
		bottom.prefWidthProperty().bind(primStage.widthProperty());
		bottom.setPadding(new Insets(10));
		bottom.setSpacing(10);
		// bottom.setBackground(color("green"));

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

        
        Slider volumeSlider = new Slider(0, 1, 0.2); 

        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            setVolume(newValue.doubleValue());
        });

       
        bottom.getChildren().addAll(playButton, pauseButton, prevButton, nextButton, progressBar, currentlyPlayingLabel, volumeSlider);

		return bottom;
	}

	private void setTitleToSong() {
		primStage.setTitle(primLibrary.currentPlaylist.currentSong.toString());
	}
    // Method to play the next song
    private void playNextSong() {
        primLibrary.currentPlaylist.next();
        System.out.println("Next button clicked");
		setTitleToSong();
    }

    // Method to play the previous song
    private void playPreviousSong() {
        System.out.println("Previous button clicked");
    	primLibrary.currentPlaylist.back();
		setTitleToSong();
    }

    // Method to play
    private void play() {
        System.out.println("Play button clicked");
		primLibrary.currentPlaylist.play();
		setTitleToSong();
    }

    // Method to pause
    private void pause() {
        System.out.println("Pause button clicked");
		primLibrary.currentPlaylist.pause();
    }

    // Method to set volume
    private void setVolume(double volume) {
        System.out.println("Volume changed: " + volume);
		primLibrary.currentPlaylist.setVolume(volume);
    }
}