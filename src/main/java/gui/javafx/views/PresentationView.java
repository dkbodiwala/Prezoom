package gui.javafx.views;

import app.interfaces.DrawingAdapterI;
import app.model.Sheet;
import gui.javafx.DrawingAdapter;
import gui.javafx.Entry;
import gui.javafx.Transform;
import gui.javafx.controllers.PresentationController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class PresentationView extends Canvas {
    private final Sheet model;
    private final PresentationController controller;

    public PresentationView(PresentationController controller) {
        this.model = Entry.model;
        this.controller = controller;
        widthProperty().addListener(e -> draw());
        heightProperty().addListener(e -> draw());
        DoubleProperty opacity  = new SimpleDoubleProperty();

        // Timeline timeline = new Timeline(
        //     new KeyFrame(Duration.seconds(0),
        //             new KeyValue(opacity, 1)
        //     ),
        //     new KeyFrame(Duration.seconds(3),
        //             new KeyValue(opacity, 0)
        //     )
        // );
        // timeline.setAutoReverse(true);
        // timeline.setCycleCount(Timeline.INDEFINITE);

        // AnimationTimer timer = new AnimationTimer() {
        //     @Override
        //     public void handle(long now) {
        //         GraphicsContext gc = getGraphicsContext2D();
        //         gc.setFill(Color.CORNSILK);
        //         gc.fillRect(0, 0, getWidth(), getHeight());
        //         gc.setFill(Color.FORESTGREEN.deriveColor(0, 1, 1, opacity.get()));
        //         gc.fillOval(
        //             300,
        //             300,
        //             100,
        //             100
        //         );
        //         // draw();
        //     }
        // };

        this.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                controller.getNext();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                controller.getPrevious();
            }
        });

        this.requestFocus();
        this.setFocusTraversable(true);

        this.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.UP) {
                controller.getNext();
            } else if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.DOWN) {
                controller.getPrevious();
            }
        });
        // draw();


        // timer.start();
        // timeline.play();
        draw();
    }

    public void update() {
		draw() ;
	}

    private void draw() {
        double width = getWidth();
        double height = getHeight();

        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.web(model.getCurrentState().getBackgroundColor()));

        Transform transform = new Transform(width, height, model.getWidth(), model.getHeight());
        DrawingAdapterI drawingAdapter = new DrawingAdapter(gc, transform, width, height);
        model.draw(drawingAdapter);
    }
}