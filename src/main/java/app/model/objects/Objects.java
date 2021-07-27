package app.model.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import app.interfaces.ObjectsI;
import app.model.attributes.XPosition;
import app.model.attributes.YPosition;
import app.model.attributes.AttributeLabel;
import app.model.attributes.Attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 * Class: This is the super class for all the objects;   
 */

public abstract class Objects implements ObjectsI {
    private List<Attributes> attributes;
    private static int count = 1;
    private String type;
    private int linkId;
    private int id;

    /**
     * this constructor adding the X and Y poistion of all the objects;
     * @param x
     * @param y
     * @param type
     */
    

    public Objects(String x, String y, String type) {
        attributes = new ArrayList<>();
        addAttribute(new XPosition(x));
        addAttribute(new YPosition(y));
        this.id = count++;
        this.type = type;
    }

    /**
     * this sub-routine set the link between the object via Object Id;
     * @param id
     */

    public void setLinkId(int id) {
        this.linkId = id;
    }

    /**
     * this sub-routine return the Object Id;
     * @return id;
     */

    public int getId() {
        return id;
    }

    /**
     * @return Link id;
     */

    public int getLinkId() {
        return linkId;
    }

    /**
     * this sub-routines retruns the X-position of the object;
     * @return X-position;
     */

    public double getX() {
        return Double.parseDouble(getAttributes().get(AttributeLabel.X_POSITION.getLabel()));
    }

    /**
     * this sub-routines retruns the Y-position of the object;
     * @return Y-position;
     */

    public double getY() {
        return Double.parseDouble(getAttributes().get(AttributeLabel.Y_POSITION.getLabel()));
    }

    /**
     * this sub-routines retruns type of the Object;
     * @return type;
     */

    public String getType() {
        return type;
    }

     /**
     * this sub-routines add attributes to the Object;
     * @param attributes;
     */

    protected void addAttribute(Attributes attribute) {
        this.attributes.add(attribute);
    }

     /**
     * this sub-routines set attributes to the Object;
     * @param key,value;
     */

    public void setAttribute(String key, String value) {
        for (Attributes attribute : attributes) {
            if (key.equals(attribute.getLabel())) {
                attribute.setData(value);
            }
        }
    }

    /**
     * this sub-routine returns all the attributes of the object;
     * @return all attributes;
     */

    public Map<String, String> getAttributes() {
        Map<String, String> map = new HashMap<>();

        for (Attributes attribute : attributes) {
            map.put(attribute.getLabel(), attribute.getData());
        }

        return map;
    }
}