package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TTest {
	StringProperty firstName;
	StringProperty artistName;

	public TTest(String firstName, String artistName) {
		setFirstName(firstName);
		setArtistName(artistName);
	}
	public void setArtistName(String aristName) {
		artistNameProperty().set(aristName);
	}

	public String getArtistName() {
		return artistNameProperty().get();
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
	public StringProperty artistNameProperty() {
		if (artistName == null) 
			artistName = new SimpleStringProperty(this, "artistName");
		return artistName;
	}
}
