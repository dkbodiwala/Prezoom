package gui.javafx.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import app.exceptions.InvalidObjectTypeException;
import app.model.Sheet;
import app.model.attributes.AttributeLabel;
import app.model.objects.ObjectType;
import app.utility.PropertyName;
import app.utility.Trigger;
import gui.javafx.Entry;
import gui.javafx.Transform;
import gui.javafx.views.EditView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 *  This is Editcontroller class which controlls the view and observes the model.
 */

public class EditController implements PropertyChangeListener {
    private Sheet model;
    private EditView view;

    @FXML
    private Pane pane;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private ImageView presentButton;

    @FXML
    private Button previewButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button cameraButton;

    @FXML
    private Button transitionsButton;

    @FXML
    private Button interpolationsButton;

    @FXML
    private ImageView addButton;

    @FXML
    private Label leftStatus;

    @FXML
    private Label rightStatus;

    @FXML
    private HBox bar;

    @FXML
    private GridPane changes;

    // Shapes
    @FXML
    private Rectangle rectangle;

    @FXML
    private Circle circle;

    @FXML
    private ImageView image;

    @FXML
    private Text text;

    @FXML
    private Line line;

    @FXML
    private Pane content;

    /**
    * This sub-routine is used to update the view.  
    */    
    public void initialize() {
        this.model = Entry.model;
        this.view = new EditView();
        updateStates(model.getSheetSize());
        model.addPropertyChangeListener(this);

        pane.getChildren().clear();
        pane.getChildren().add(view);
        view.widthProperty().bind(pane.widthProperty());
        view.heightProperty().bind(pane.heightProperty());
        
        line.getProperties().put("name", ObjectType.LINE.getType());
        image.getProperties().put("name", ObjectType.IMAGE.getType());
        circle.getProperties().put("name", ObjectType.CIRCLE.getType());
        text.getProperties().put("name", ObjectType.PLAIN_TEXT.getType());
        content.getProperties().put("name", ObjectType.TEXT_AREA.getType());
        rectangle.getProperties().put("name", ObjectType.RECTANGLE.getType());
    }

    /**
    * This sub-routine handle the saving of sheet. 
     */
    @FXML
    public void handleSaveClick() {
        // interactor.logger("Saving file");
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.alpha"));

        File f = chooser.showSaveDialog(saveButton.getScene().getWindow());
        if (f != null) {
            try {
                PrintWriter file = new PrintWriter(new FileWriter(f.getAbsolutePath()));
                model.saveTo(file);
                file.close();
            }
            catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error !");
                alert.setHeaderText(null);
                alert.setContentText("Error Saving Sheet To File !");
                alert.showAndWait();
            }}
    }


    /**
    * This sub-routine handle the loading of sheet from the desktop. 
    */
    @FXML
    public void handleLoadClick() {
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Load Application File");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.alpha"));

        File f = chooser.showOpenDialog(loadButton.getScene().getWindow());
        if (f != null) {
            try {
                BufferedReader file = new BufferedReader(new FileReader(f.getAbsolutePath()));
                model.loadFrom(file);
                file.close();
                if (model.getSheetSize() > 0) {
                    view.update();
                }
            }
            catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error !");
                alert.setHeaderText(null);
                alert.setContentText("Error Loading SheetFrom File !");
                alert.showAndWait();
            }
        }
    }

    /**
    * This sub-routine is used to switch to presentation mode. 
    */
    @FXML
    public void handlePresentClick() throws Exception {
        model.setCurrentStateIndex(0);
        Stage stage = new Stage();
        
        URL url = new File("src/main/java/gui/javafx/fxml/presentation_mode.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        scene.setCursor(Cursor.NONE);
        stage.setScene(scene);

        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    /**
    * This sub-routine is used to preview. 
    */
    @FXML
    private void handlePreviewClick() {
        // interactor.logger("Preview!!!");
    }
 
    
    /**
    * This sub-routine is handle the settings. 
    */
    @FXML
    private void handleSettingsClick() {
        setSideLabel("Settings");
        ComboBox<Trigger> trigger = new ComboBox<>(FXCollections.observableArrayList(Trigger.values()));
        trigger.setValue(model.getCurrentState().getTrigger());
        trigger.setOnAction(e ->{
            model.getCurrentState().setTrigger(trigger.getValue());
        });

        ColorPicker background = new ColorPicker();
        background.setStyle("-fx-color-label-visible:false;");
        background.setValue(Color.web(model.getCurrentState().getBackgroundColor()));

        background.setOnAction(e -> {
            model.getCurrentState().setBackgroundColor(background.getValue().toString());
            view.update();
        });

        addLabel(trigger, "Trigger Type", 3);
        addLabel(background, "Background", 4);

        addToSideLabel("Camera", 5);
        model.getCurrentState().setCurrentObjectIndex(0);
        setSideAttributes(model.getCurrentCameraAttributes(), 7);
    }

    /**
    * This sub-routine handles the Transitions. 
    */
    @FXML
    private void handleTransitionsClick() {
        // interactor.logger("Transitions!!!");
    }

    /**
    * This sub-routine offers the multiple modes of interpolation to user . 
    */
    @FXML
    public void handleInterpolationsClick() {
        // interactor.logger("Interpolations!!!");
    }

    /**
    * This sub-routine handle the camara. 
    */
    @FXML
    private void handleCameraClick() {
        // interactor.logger("Camera!!!");
    }

    /**
    * This sub-routine is used to add the state. 
    */
    @FXML
    private void handleAddClick() {
        changes.getChildren().clear();
        model.addState();
        view.update();
    }

    /**
    * This sub-routine hadles the drag event
    * @param :event :- drag detection   
    */
    @FXML
    private void handleDragDetected(MouseEvent event) {
        Node node = (Node) event.getSource();
        String object = node.getProperties().get("name").toString();

        // interactor.logger(object + " selected");
        Dragboard dragboard = node.startDragAndDrop(TransferMode.COPY);

        // SnapshotParameters snapshotParams = new SnapshotParameters();
        // WritableImage image = node.snapshot(snapshotParams, null);
        // dragboard.setDragView(image, event.getX(), event.getY());

        ClipboardContent cc = new ClipboardContent();
        cc.putString(object);

        dragboard.setContent(cc);
        event.consume();
    }

    /**
     * This sub-routine is used to change the cursor when cursor on any object. 
     * @param :event :- enter detection 
    */
    @FXML
    private void handleMouseEntered(MouseEvent event) {
        ((Node) event.getSource()).setCursor(Cursor.OPEN_HAND);
    }

    /**
    * This sub-routine is used to exit from the change. 
    @param :event :- exit detection 
    */
    @FXML
    private void handleMouseExited(MouseEvent event) {
        ((Node) event.getSource()).setCursor(Cursor.DEFAULT);
    }

    /**
    * This sub-routine is used to update the view. 
    * @param size :-updated size of state. 
    */
    public void updateStates(int size) {
        bar.getChildren().clear();
        int activeState = model.getCurrentStateIndex();
        
        for (int i = 0; i < size; i++) {
            Button node = new Button(String.valueOf(i + 1));

            final int index = i;
            if (index == activeState) {
                node.requestFocus();
                node.setStyle("-fx-font-size:9; -fx-background-color: #add8e6");
            } else {
                node.setStyle("-fx-font-size:9");
            }

            bar.getChildren().add(node);
            ContextMenu menu = new ContextMenu();
            MenuItem delete = new MenuItem("Delete");
            MenuItem replicate = new MenuItem("Replicate");

            replicate.setOnAction((ActionEvent e) -> {
                try {                
                    model.replicateState(index);
                } catch (InvalidObjectTypeException exception) {
                    exception.printStackTrace();
                }
            });

            delete.setOnAction((ActionEvent e) -> {
                model.removeState(index);
                updateStates(model.getSheetSize());
            });

            menu.getItems().add(replicate);
            menu.getItems().add(delete);

            node.setOnMousePressed(e -> {
                if (e.getButton() == MouseButton.SECONDARY) {
                    menu.show(node, e.getScreenX(), e.getScreenY());
                }
            });

            node.setOnAction(e -> {
                model.setCurrentStateIndex(index);
                updateStates(model.getSheetSize());
            });
            
            view.update();
        }
    }

    /**
    * This sub-routine is used to show Attributes of the clicked object. 
    */
    public void showAttributes() {
        Map<String, String> attr = model.getObjectAttributes();
        setSideLabel("Transitions");
        setSideAttributes(attr, 3);
    }

    
    public void setSideAttributes(Map<String, String> attr, int position) {
        Transform transform = new Transform(view.getWidth(), view.getHeight(), model.getWidth(), model.getHeight());

        var wrapper = new Object(){
            double i;
            double j;
            String iKey; 
            String jKey;      
        };

        attr.computeIfPresent(AttributeLabel.X_POSITION.getLabel(), (k, v) -> {
            wrapper.i = Double.parseDouble(v);
            wrapper.iKey = k;
            return null;
        });

        attr.computeIfPresent(AttributeLabel.Y_POSITION.getLabel(), (k, v) -> {
            wrapper.j = Double.parseDouble(v);
            wrapper.jKey = k;
            return null;
        });
        
        
        Point2D p = transform.worldToView(wrapper.i, wrapper.j);
        if (attr.containsKey(AttributeLabel.STROKE_COLOR.getLabel())) {
            String key = AttributeLabel.STROKE_COLOR.getLabel();
            addColor(key, attr.get(key), position);
            attr.remove(key);
            position++;
        } if (attr.containsKey(AttributeLabel.FILL_COLOR.getLabel())) {
            String key = AttributeLabel.FILL_COLOR.getLabel();
            addColor(key, attr.get(key), position);
            attr.remove(key);
            position++;
        } if (attr.containsKey(AttributeLabel.SOURCE.getLabel())) {
            String key = AttributeLabel.SOURCE.getLabel();
            addImage(key, attr.get(key), position);
            attr.remove(key);
            position++;
        }       
        
        addText(wrapper.iKey, String.valueOf(p.getX()), position++);
        addText(wrapper.jKey, String.valueOf(p.getY()), position++);

        if (attr.containsKey(AttributeLabel.Y_POSITION.getLabel())) {
            String key = AttributeLabel.Y_POSITION.getLabel();
            addText(key, attr.get(key), position);
            attr.remove(key);
            position++;
        }
        
        for (Map.Entry<String, String> entry : attr.entrySet()) {
            addText(entry.getKey(), entry.getValue(), position);
            position++;
        }
    }

    public void setSideLabel(String text) {
        changes.getChildren().clear();
        Label label = new Label(text);
        label.setStyle("-fx-font-weight:bold; -fx-font-size:15");

        changes.add(label, 0, 1, 2, 1);
        changes.add(new Label(), 0, 2, 2, 1);
    }

    public void addToSideLabel(String text, int position) {
        Label label = new Label(text);
        label.setStyle("-fx-font-weight:bold; -fx-font-size:12");

        changes.add(new Label(), 0, position++, 2, 1);
        changes.add(label, 0, position, 2, 1);
    }

    /**
    * This sub-routine is allow a user to change the color of an existing object. 
    * @param key :it is attribute name.
    * @param value : it is attribute vlue.
    * @param position : it is attribute position.
    */
    public void addColor(String key, String value, int position) {
        Map<String, String> attr = new HashMap<>();
        ColorPicker color = new ColorPicker(Color.web(value));
        color.setStyle("-fx-color-label-visible:false;");
        color.setOnAction(e -> {
            attr.put(key, color.getValue().toString());
            model.updateObject(attr);            
            view.update();
        });

        addLabel(color, key, position);
    }

    /**
    * This sub-routine is allow user to displaying and changing of attribute. 
    * @param key :it is attribute name.
    * @param value : it is attribute vlue.
    * @param position : it is attribute position.
    */
    public void addText(String key, String value, int position) {
        Map<String, String> attr = new HashMap<>();
        TextField textField = new TextField(value);
        if (value.matches("-?\\d+(\\.\\d+)?")) {
            textField.addEventFilter(KeyEvent.ANY, e -> {
                // char ar[] = e.getCharacter().toCharArray();
                // char ch = ar[e.getCharacter().toCharArray().length - 1];
                // if (!(ch >= '0' && ch <= '9')) {
                //     e.consume();
                // }
            });
        }
        textField.textProperty().addListener((e, old, text) -> {
            attr.put(key, textField.getText());
            model.updateObject(attr);            
            view.update();
        });

        addLabel(textField, key, position);
    }

    public void addImage(String key, String value, int position) {
        Map<String, String> attr = new HashMap<>();
        ImageView img = new ImageView(value);
        
        img.setOnMouseClicked(e -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Select image");
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.*"));

            File file = chooser.showOpenDialog(saveButton.getScene().getWindow());
            if (file != null) {
                String val = file.toURI().toString();
                img.setImage(new Image(val));
                img.setPreserveRatio(true);
                attr.put(key, val);

                model.updateObject(attr);            
                view.update();
            } else {
                // interactor.logger("Load cancelled");
            }
        });

        addLabel(img, key, position);
    }

    /**
     * This Sub-routine adds the label.
     * @param :node :- shape
     * @param :key :- name of the shape
     * @param :position :- position of the shape
     */
    public void addLabel(Node node, String key, int position) {
        changes.add(new Label(key), 0, position, 1, 1);
        changes.add(node, 1, position, 1, 1);
    }

    /**
     * This Sub-routine handles changes from the sheet by observing it.
     * @param :event
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (PropertyName.STATES.getName().equals(event.getPropertyName())) {
            updateStates((int) event.getNewValue());
        } else if (PropertyName.ATTRIBUTES.getName().equals(event.getPropertyName())) {
            changes.getChildren().clear();
            if ((boolean) event.getNewValue()) {
                showAttributes();
            }
        }
    }
}
