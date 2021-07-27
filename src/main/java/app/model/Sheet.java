package app.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.exceptions.InvalidObjectTypeException;
import app.interfaces.DrawingAdapterI;
import app.model.objects.Objects;
import app.utility.PropertyName;
import app.utility.Trigger;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * Class : This class represents sheet.
 * this sheet class handles the states and it is also observable class that notify the editcontroller;
 */

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * Class : This class represents sheet.
 * this sheet class handles the states and it is also observable class that notify the editcontroller;
 */

public class Sheet {
    private int currentStateIndex;
    private boolean selectedObject;

    private boolean notify;
    private List<States> states;
    private PropertyChangeSupport observable;

    private static final double WIDTH = 1080.0;
    private static final double HEIGHT = 720.0;

    /**
     * default constructor which setup the list for storing the states;
     * also add one default state on the sheet;
     */

    public Sheet() {
        this.notify = true;
        this.selectedObject = false;
        this.states = new ArrayList<>();
        this.observable = new PropertyChangeSupport(this);

        addState();
    }

    /**
     * this sub-routine allows to add the observers to sheet class; 
     * @param pcl;
     */

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        observable.addPropertyChangeListener(pcl);
    }
    
    /**
     * this sub-routine allows to removes the observers to sheet class
     * @param pcl;
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        observable.removePropertyChangeListener(pcl);
    }

    /**
     * this sub-routine sets the sheet to indeed send notifications
     * @param notify;
     */
    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    /**
     * this sub-routine sets the index of the current state;
     * @param index;
     */
    public void setCurrentStateIndex(int index) {
        this.currentStateIndex = index;
    }

    /**
     * this sub-routine sets the selected object;
     * @param selected;
     */

    public void setHasSelectedObject(boolean selected) {
        this.selectedObject = selected;
    }

    /**
     * this sub-routine returns the TRUE when object is selected;
     * @return selectedObject;
     */

    public boolean hasSelectedObject() {
        return selectedObject;
    }

    /**
     * this sub-routine returns the height of the sheet;
     * @return height;
     */

    public double getHeight() {
        return HEIGHT;
    }

    /**
     *  this sub-routine returns the width of the sheet;
     * @return width;
     */
    public double getWidth() {
        return WIDTH;
    }

    /**
     *  this sub-routine returns the notification status of the sheet;
     * @return notify;
     */
    public boolean getNotify() {
        return notify;
    }
   
    /**
     * this sub-routine returns the size of the list that stores the states; 
     * @return size;
     */
    public int getSheetSize() {
        return states.size();
    }

    /**
     * this sub-routine return the current state by using current state index;
     * @return currentState;
     */

    public States getCurrentState() {
        return states.get(currentStateIndex);
    }

    public States getNextState() {
        if (currentStateIndex < getSheetSize() - 1) {
            return states.get(currentStateIndex);
        }

        return null;
    }

    /**
     * this sub-routine return the id of current state;
     * @return Id;
     */

    public int getCurrentStateId() {
        return getCurrentState().getId();
    }

    /**
     * this sub-routine return the  index of current state;
     * @return currentStateIndex;
     */

    public int getCurrentStateIndex() {
        return currentStateIndex;
    }

    /**
     * this sub-routine return the size of current state;
     * @return size of currentState;
     */

    public int getCurrentStateSize() {
        return getCurrentState().getStateSize();
    }

    /**
     * this sub-routine return the camera attributes;
     * @return cameraAttribures;
     */

    public Map<String, String> getCurrentCameraAttributes() {
        return getCurrentState().getCameraAttributes();
    }

    /**
     * this sub-routines returns the list of states;
     * @return states;
     */

    public List<States> getStates() {
        return states;
    }

    /**
     * this sub-routine adding the states and stores into the list
     * it also notify the others observers;
     */

    public void addState() {
        int size = getSheetSize();
        States state = new States();

        states.add(state);
        setCurrentStateIndex(getSheetSize() - 1);
        if (getNotify()) {
            observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
        }
    }

    /**
     * this sub-routine replicate the states and again store into the list;
     * it also notify the others observers; 
     * throws exception when there is invalid object entered;
     * @param index
     * @throws InvalidObjectTypeException
     */

    public void replicateState(int index) throws InvalidObjectTypeException {
        int size = getSheetSize();
        States state = new States();
        for (Objects object : states.get(index).getObjects()) {
            state.addObject(object.getType(), object.getX(), object.getY());
            state.updateObject(object.getAttributes());
            object.setLinkId(state.getCurrentObjectId());
        }

        states.add(state);
        setCurrentStateIndex(getSheetSize() - 1);
        if (getNotify()) {
            observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
        }
    }

    /**
     * this sub-routine remove the states from the sheet;
     * @param index
     */

    public void removeState(int index) {
        int size = getSheetSize();
        states.remove(index);

        if (size == 1) {
            addState();
        } else {
            setCurrentStateIndex(index == 0 ? 0 : index - 1);
        } if (getNotify()) {
            observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
        }
    }

    /**
     * this sub-routine adds objects to the states;
     * also throws the exception when invalid object is added into state;
     * @param type
     * @param xPosition
     * @param yPosition
     * @throws InvalidObjectTypeException
     */

    public void addObject(String type, double xPosition, double yPosition) throws InvalidObjectTypeException {
        States state = getCurrentState();
        state.addObject(type, xPosition, yPosition);
    }

    /**
     * this sub-routine updates the attributrs of the objects;
     * @param attr
     */

    public void updateObject(Map<String, String> attr) {
        getCurrentState().updateObject(attr);
        setHasSelectedObject(true);
    }

    /**
     * this sub-routine returns the objects attributes;
     * @return
     */

    public Map<String, String> getObjectAttributes() {
        return states.get(currentStateIndex).getObjectAttributes();
    }

    /**
     * this sub-routine helps the select the object;
     * @param x
     * @param y
     */

    public void selectObjectAt(double x, double y) {
        States state = getCurrentState();
        boolean selected = state.selectObject(x, y);
        if (getNotify()) {
            observable.firePropertyChange(PropertyName.ATTRIBUTES.getName(), null, selected);
        }
    }

    /**
     * this sub-routines draw all objects expect the camera object;
     * @param drawingAdapter
     */

    public void draw(DrawingAdapterI drawingAdapter) {
        for (Objects object : getCurrentState().getAllObjects()) {
            object.draw(drawingAdapter);
        }
    }

    /**
     * this sub-routines draw one objects at a time;
     * @param drawingAdapter
     * @param index
     */
    public void drawObject(DrawingAdapterI drawingAdapter, int index) {
        getCurrentState().getAllObjects().get(index).draw(drawingAdapter);
    }

    public void saveTo(PrintWriter p) {
        p.println("current_state:" + getCurrentStateIndex());

        for (States state : states) {
            p.println("state:" + state.getId());
            p.println("trigger:" + state.getTrigger());
            p.println("background:" + state.getBackgroundColor());

            for (Objects object : state.getAllObjects()) {
                p.println("object:" + object.getType() + "|" + object.getX() + "|" + object.getY());
                p.println("link_id:" + object.getLinkId());
                for (Map.Entry<String, String> attribute : object.getAttributes().entrySet()) {
                    p.println(attribute.getKey() + ":" + attribute.getValue());
                }
            }
        }
    }

    public void loadFrom(BufferedReader file) {
        states.clear();
        setNotify(false);
        boolean camera = false;

        int current = 0;
        States state = null;
        Objects object = null;
        Map<String, String> attributes = new HashMap<>();

        try {
            for (String line = file.readLine(); line != null; line = file.readLine()) {
                String[] element = line.split(":");
                if (element[0].trim().equals("current_state")) {
                    current = Integer.parseInt(element[1]);
                } else  if (element[0].trim().equals("state")) {
                    addState();
                    attributes.clear();
                    state = getCurrentState();
                } else if (element[0].trim().equals("trigger")) {
                    state.setTrigger(Trigger.valueOf(element[1]));
                } else if (element[0].trim().equals("background")) {
                    state.setBackgroundColor(element[1]);
                } else if (element[0].trim().equals("object")) {
                    if (attributes.size() > 0) {
                        if (camera == true) {
                            state.setCurrentObjectIndex(0);
                            updateObject(attributes);
                            camera = false;
                        } else {
                            updateObject(attributes);
                        }
                        attributes.clear();
                    }

                    String[] obj = element[1].split("\\|"); 
                    if (obj[0].trim().equals("Camera")) {
                        camera = true;
                    } else {
                        state.addObject(obj[0], Double.parseDouble(obj[1]), Double.parseDouble(obj[1]));
                        object = getCurrentState().getCurrentObject();
                    }
                } else if (element[0].trim().equals("link_id") && Integer.parseInt(element[1]) > 0) {
                    object.setLinkId(Integer.parseInt(element[1]));
                } else {
                    attributes.put(element[0], element[1]);
                }
            }
        } catch (NumberFormatException | IOException | InvalidObjectTypeException e) {
            e.printStackTrace();
        }

        setCurrentStateIndex(current);
    }
}