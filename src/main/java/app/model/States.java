package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.exceptions.InvalidObjectTypeException;
import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;
import app.model.attributes.FillColor;
import app.model.objects.Camera;
import app.model.objects.ObjectFactory;
import app.model.objects.ObjectType;
import app.model.objects.Objects;
import app.utility.Trigger;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * Class : This class represents sheet.
 * this state class handles the objects;
 */

public class States {
    private int id;
    private static int count = 1;
    private List<Objects> objects;

    private int currentObjectIndex;

    private Trigger trigger;

    private FillColor backgroud;

    /**
     * this constructor set the white background to sheet
     * also set the list for storing the objects
     * increase object id every time new object is created;
     */

    public States() {
        this.backgroud = new FillColor("#FFFFFF");
        this.trigger = Trigger.IMMEDIATE;
        this.objects = new ArrayList<>();
        objects.add(new Camera());
        this.id = count++;
    }

    /**
     * this sub-routine return id of object;
     * @return Id
     */

    public int getId() {
        return id;
    }

    /**
     * this sub-routine set up the trigger value;
     * @param trigger
     */

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    /**
     * this sub-routine set up the background color of the state;
     * @param data
     */

    public void setBackgroundColor(String data) {
        this.backgroud.setData(data);
    }

    /**
     * this sub-routine set up the object index;
     * @param index
     */

    public void setCurrentObjectIndex(int index) {
        this.currentObjectIndex = index;
    }

    /**
     * this sub-routines return the currentObject with help of current object index;
     * @return currentObject
     */

    public Objects getCurrentObject() {
        return objects.get(currentObjectIndex);
    }

    /**
     * this sub-routines return the trigger;
     * @return trigger;
     */

    public Trigger getTrigger() {
        return trigger;
    }

    /**
     * this sub-routines return the value of backgroundcolor of the state;
     * @return background color;
     */

    public String getBackgroundColor() {
        return backgroud.getData();
    }

    /**
     * this sub-routines return the id of current object;
     * @return currentObjectId;
     */

    public int getCurrentObjectId() {
        return getCurrentObject().getId();
    }

    /**
     * this sub-routines return the index of current object;
     * @return currrentObjectIndex;
     */

    public int getCurrentObjectIndex() {
        return currentObjectIndex;
    }

    /**
     * this sub-routines return the size of objects stored into list;
     * @return size
     */

    public int getStateSize() {
        return objects.size() - 1;
    }

    /**
     * this sub-routine retrun the all objects instead of camera; 
     * this are objects that shown in the presentation mode;
     * @return objects;
     */

    public List<Objects> getObjects() {
        return objects.subList(1, objects.size());
    }

     /**
     * this sub-routine retrun the all objects; 
     * @return objects;
     */

    public List<Objects> getAllObjects() {
        return objects;
    }

    /**
     * this sub-routine retrun attributes of the camera; 
     * @return cameraattributes;
     */

    public Map<String, String> getCameraAttributes() {
        return objects.get(0).getAttributes();
    }

    /**
     * this sub-routines add the object into the state;
     * thwows are exception when invalid object is added;
     * @param type
     * @param xPosition
     * @param yPosition
     * @throws InvalidObjectTypeException
     */

    public void addObject(String type, double xPosition, double yPosition) throws InvalidObjectTypeException {
        ObjectsI object;
        ObjectFactoryI factory = new ObjectFactory();

        String x = String.valueOf(xPosition);
        String y = String.valueOf(yPosition);

        if (ObjectType.CIRCLE.getType().equals(type)) {
            object = factory.makeCircle(x, y);
        } else if (ObjectType.IMAGE.getType().equals(type)) {
            object = factory.makeImage(x, y);
        } else if (ObjectType.LINE.getType().equals(type)) {
            object = factory.makeLine(x, y);
        } else if (ObjectType.PLAIN_TEXT.getType().equals(type)) {
            object = factory.makePlainText(x, y);
        } else if (ObjectType.TEXT_AREA.getType().equals(type)) {
            object = factory.makeTextArea(x, y);
        } else if (ObjectType.RECTANGLE.getType().equals(type)) {
            object = factory.makeRectangle(x, y);
        } else {
            throw new InvalidObjectTypeException(type);
        }

        objects.add((Objects) object);
        setCurrentObjectIndex(objects.size() - 1);
    }

    /**
     * this sub-routines update the object's attributes;
     * @param attr
     */
    public void updateObject(Map<String, String> attr) {
        Objects object = objects.get(currentObjectIndex);
        for (Map.Entry<String, String> entry : attr.entrySet()) {
            object.setAttribute(entry.getKey(), entry.getValue());
        }
    }

    /**
     * this sub-routine return the attributes of the current object;
     * @return attributes of current object;
     */

    public Map<String, String> getObjectAttributes() {
        return objects.get(currentObjectIndex).getAttributes();
    }

    /**
     * his sub-routine return the boolean value if object is selected from the UI ;
     * @param x
     * @param y
     * @return TRUE of FALSE with respect to the object is selected or not;
     */

    public boolean selectObject(double x, double y) {
        int index = 1;
        boolean found = false;
        for (Objects object : getObjects()) {
            if (object.locatedAt(x, y)) {
                setCurrentObjectIndex(index);
                found = true;
                break;
            }

            index++;
        }

        return found;
    }
};

