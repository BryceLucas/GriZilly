package grizilly;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Skeleton extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public Stage primStage;

	@Override
	public void start(Stage prim) {
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

	private Background color(String color) {
		Background x = Background.fill(Paint.valueOf(color));
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
		return middle;
	}
	private TableView<TTest> buildPlaylistTable() {
				TableView<TTest> playlistTable = new TableView<>();
		playlistTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

		TableColumn<TTest, String> column = new TableColumn<>("Special playlists");
		playlistTable.getColumns().add(column);
	//this is what should show in the column 
		TTest tt = new TTest("name1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		playlistTable.getItems().add(tt);
	
		playlistTable.getItems().add(new TTest("Music"));
	//this should be making the name show in the column but it doesnt idk why
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
		TableView<String> songTable = new TableView<>();
	// allow the songtable to be big, and to resize itself when winndow changes size
		songTable.prefHeightProperty().bind(primStage.heightProperty());
		songTable.prefWidthProperty().bind(primStage.widthProperty());

		TableColumn<String, String> songName = new TableColumn<>("song name");
		TableColumn<String, String> songArtist = new TableColumn<>("songs artist");
		TableColumn<String, String> songLength = new TableColumn<>("Lengthsssssssssssssssss");

		songTable.getColumns().addAll(songName, songArtist, songLength);
		songPane.getChildren().addAll(songTable);

		return songPane;
	}
	private HBox bottom() {
		HBox bottom = new HBox();
		bottom.prefHeight(140);
		bottom.prefWidthProperty().bind(primStage.widthProperty());
		bottom.setPadding(new Insets(10));

		bottom.setBackground(color("green"));


		Button button = new Button("heeeeeeeeeeeeeeeelp");
		bottom.getChildren().add(button);

		return bottom;
	}
}

class TTest {
	private StringProperty firstName;

	public TTest(String firstName) {
		setFirstName(firstName);
	}
	public void setFirstName(String value) {
		firstNameProperty().set(value);
	}

	public String getFirstName() {
		return firstNameProperty().get();
	}

	public StringProperty firstNameProperty() {
		if (firstName == null)
			firstName = new SimpleStringProperty(this, "firstName");
		return firstName;
	}


}