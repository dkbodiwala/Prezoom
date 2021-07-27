package app.interfaces;

import java.util.Map;
/**
* @author Team Alfa
* @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
*
* Class : This class represents the Objects Interface.
* This interface contains declaration of four methods: getAttributes, setAttribute, locatedAt, draw.
 */
public interface ObjectsI {
    Map<String, String> getAttributes();

    void setAttribute(String key, String value);

    boolean locatedAt(double x, double y);

    void draw(DrawingAdapterI drawingAdapter);
}