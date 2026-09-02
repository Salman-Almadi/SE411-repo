package psu.se411.lab4;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("My Project");

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//there was an error on pom.xml, you need to go to settings/preferences and download XML.
}
