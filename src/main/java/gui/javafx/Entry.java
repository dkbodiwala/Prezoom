package gui.javafx;

import java.io.File;
import java.net.URL;

import app.model.Sheet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 * Class: This class initiate whole software and creates the new sheet at the start of the software.
 */

public class Entry extends Application {
    public static Sheet model = new Sheet();

    /**
     * This sub-routine sets the primary environment at the start of the software.
     * @param primaryStage
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/main/java/gui/javafx/fxml/edit_mode.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle(app.Main.getTitle());
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
