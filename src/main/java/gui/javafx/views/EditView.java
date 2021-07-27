package gui.javafx.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

import app.exceptions.InvalidObjectTypeException;
import app.interfaces.DrawingAdapterI;
import app.model.Sheet;
import app.model.attributes.AttributeLabel;
import gui.javafx.DrawingAdapter;
import gui.javafx.Entry;
import gui.javafx.Transform;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;

public class EditView extends Canvas implements PropertyChangeListener {
    private final Sheet model;

    public EditView() {
        this.model = Entry.model;
        widthProperty().addListener(e -> draw());
        heightProperty().addListener(e -> draw());

        this.setOnDragOver(e -> {
            if (e.getDragboard().hasString()) {
                e.acceptTransferModes(TransferMode.ANY);
                e.consume();
            }
        });

        this.setOnDragDropped(e -> {
            Transform transform = new Transform(getWidth(), getHeight(), model.getWidth(), model.getHeight());
            Point2D p = transform.viewToWorld(e.getX(), e.getY());
            String type = e.getDragboard().getString();

            try {                
                model.addObject(type, p.getX(), p.getY());
            } catch (InvalidObjectTypeException exception) {
                exception.printStackTrace();
            }
            
            e.setDropCompleted(true);
            model.selectObjectAt(p.getX(), p.getY());
            draw();
        });
        
        this.setOnMousePressed(e -> {
            Transform transform = new Transform(getWidth(), getHeight(), model.getWidth(), model.getHeight());
            Point2D p = transform.viewToWorld(e.getX(), e.getY());
            model.selectObjectAt(p.getX(), p.getY());
            draw();
        });

        this.setOnMouseDragged(e -> {
            if (e.isShiftDown() && model.getCurrentStateSize() > 0) {
                Transform transform = new Transform(getWidth(), getHeight(), model.getWidth(), model.getHeight());
                Point2D p = transform.viewToWorld(e.getX(), e.getY());

                Map<String, String> attr = new HashMap<>();
                attr.put(AttributeLabel.X_POSITION.getLabel(), String.valueOf(p.getX()));
                attr.put(AttributeLabel.Y_POSITION.getLabel(), String.valueOf(p.getY()));
                model.updateObject(attr);
                update();
            }
        });

        this.requestFocus(); // Needed to handle key events

        this.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.DELETE) {
                System.out.println("Delete");
                // Delete all selected Edges
                // for (Edge e:  graph.selectedEdges())
                //     graph.deleteEdge(e);
                // // Delete all selected Nodes
                // for (Node n:  graph.selectedNodes())
                //     graph.deleteNode(n);
                // Update the view, by redrawing the Graph
                update();
            }
        });

        draw();
    }

    public void update() {
		draw() ;
	}

    private void draw() {
        int index = 0;
        double width = getWidth();
        double height = getHeight();
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.web(model.getCurrentState().getBackgroundColor()));
        Transform transform = new Transform(width, height, model.getWidth(), model.getHeight());	        	
        DrawingAdapterI drawingAdapter = new DrawingAdapter(gc, transform, width, height);

        model.drawObject(drawingAdapter, index);
        model.draw(drawingAdapter);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        update();
    }
}