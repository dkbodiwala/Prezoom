package app.model.objects;

import app.model.attributes.Radius;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 * Class: This class represents the circle object and sets the attributes required for circle. 
 */

public class Circle extends Objects {

    public static final String DEFAULT_RADIUS = "100";

    /**
     * This constructor is used to add attributes and sets default value of the attributes of the Circle object.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     * @param radius - It is the radius of the circle.
     */
    public Circle(String x, String y, String radius) {
        super(x, y, ObjectType.CIRCLE.getType());
        addAttribute(new Radius(radius));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    /**
     * This constructor overloads the constructor.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     */

    public Circle(String x, String y) {
        this(x, y, DEFAULT_RADIUS);
    }
    
    /**
     * This sub-routine is used to locate the object on the canvas.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas. 
     * @return boolean 
     */
    
    @Override    
    public boolean locatedAt(double x, double y) {
        double xPos = getX();
        double yPos = getY();
        
        Map<String, String> attributes = this.getAttributes();
        double radius = Double.parseDouble(attributes.get(AttributeLabel.RADIUS.getLabel()));

        return (x - xPos) * (x - xPos) + (y - yPos) * (y - yPos) <= (radius * radius) ? true : false;
    }

    /**
     * This sub-routine draws the circle using the drawingAdapter.
     * 
     * @param DrawingAdapterI drawingAdapter - object of DrawingAdapterI
     */
    @Override    
    public void draw(DrawingAdapterI drawingAdapter) {
        double x = getX();
        double y = getY();

        Map<String, String> attributes = this.getAttributes();
        double radius = Double.parseDouble(attributes.get(AttributeLabel.RADIUS.getLabel()));
        
        drawingAdapter.setLineWidth(Double.parseDouble(attributes.get(AttributeLabel.STROKE_WIDTH.getLabel())));
        drawingAdapter.setStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));
        drawingAdapter.setFillColor(attributes.get(AttributeLabel.FILL_COLOR.getLabel()));

        drawingAdapter.drawCircle(x, y, radius);
    }
}

