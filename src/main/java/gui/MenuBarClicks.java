package gui;

import grizilly.Library;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class MenuBarClicks {
	// every time a new directory is added, will need to update the library, so it returns a library;
	public Library addDirectory(Library primLibrary) {
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
			littleWindow.hide();
		});
		h.getChildren().addAll(typeBar, finishButton);

		littleWindow.setScene(new Scene(pane));
		littleWindow.show();

		return primLibrary;
	}

	public Library createNewCustomPlaylist(Library lib) {
		Stage littleWindow = new Stage();
		littleWindow.setTitle("Enter name of playlist");
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
			lib.createCustomPlaylist(typeBar.getText());
			littleWindow.hide();
			System.out.println(lib.customPlaylists.get(0).nameOfPlaylist + " added");
		});
		h.getChildren().addAll(typeBar, finishButton);

		littleWindow.setScene(new Scene(pane));
		littleWindow.show();


		return lib;
	}
}