package gui.javafx.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.DrbgParameters.NextBytes;
import java.sql.Time;

import app.interfaces.DrawingAdapterI;
import app.model.Sheet;
import app.model.Transitions;
import gui.javafx.DrawingAdapter;
import gui.javafx.Entry;
import gui.javafx.Transform;
import gui.javafx.views.PresentationView;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class PresentationController {
    private Sheet model;

    private Canvas next;
    private Canvas current;

    @FXML
    private Pane pane;

    public void initialize() {
        this.model = Entry.model;
        this.current = new PresentationView(this);

        pane.getChildren().clear();
        pane.getChildren().add(current);
        current.widthProperty().bind(pane.widthProperty());
        current.heightProperty().bind(pane.heightProperty());
    }

    public void getNext() {
        int index = model.getCurrentStateIndex();

        if (index < model.getSheetSize() - 1) {
            model.setCurrentStateIndex(++index);
            try {
                loadScene();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getPrevious() {
        int index = model.getCurrentStateIndex();

        if (index > 0) {
            model.setCurrentStateIndex(--index);
            try {
                loadScene();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void loadScene() throws Exception {
        URL url = new File("src/main/java/gui/javafx/fxml/presentation_mode.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = current.getScene();

        root.translateYProperty().set(scene.getHeight());
        scene.setRoot(root);

        Timeline tm = new Timeline();

        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        tm.getKeyFrames().add(kf);
        tm.play();

        // GraphicsContext gc = current.getGraphicsContext2D();
        // Transform transform = new Transform(current.getWidth(), current.getHeight(), model.getWidth(), model.getHeight());
        
        // DrawingAdapterI drawingAdapter = new DrawingAdapter(gc, transform, current.getWidth(), current.getHeight());
        // Transitions transitions = new Transitions(model.getCurrentState(), model.getNextState());
        // transitions.run(drawingAdapter);
    }
}