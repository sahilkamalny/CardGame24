package org.example.cardgame24;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/hello-view.fxml")); // loads fxml file
        Scene scene = new Scene(fxmlLoader.load(), 900, 600); // loads scene from fxml file
        stage.setTitle("Card Game - 24"); // title of stage
        stage.setScene(scene); // sets the scene for the stage
        stage.show(); // shows the stage
    }

    public static void main(String[] args) {
        launch();
    }
}