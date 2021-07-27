package app.model.objects;

import app.model.attributes.Width;
import app.model.attributes.Height;

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
 * Class: This class represents the Rectangle object and sets the attributes required for the same. 
 */


public class Rectangle extends Objects {

    public static final String DEFAULT_WIDTH = "200";
    public static final String DEFAULT_HEIGHT = "160";

    /**
     * This constructor is used to add attributes and sets default value of the attributes of the Rectangle object.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     * @param width - It is width of the Rectangle.
     * @param height - It is height of the Rectangle.
     */

    public Rectangle(String x, String y, String width, String height) {
        super(x, y, ObjectType.RECTANGLE.getType());
        addAttribute(new Width(width));
        addAttribute(new Height(height));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    /**
     * This constructor overloads the constructor.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     */

    public Rectangle(String x, String y) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
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
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        double height = Double.parseDouble(attributes.get(AttributeLabel.HEIGHT.getLabel()));

        return (x >= xPos && x <= (xPos + width) && y >= yPos && y <= (yPos + height)) ? true : false;
    }

    /**
     * This sub-routine draws the Rectangle using the drawingAdapter.
     * 
     * @param DrawingAdapterI drawingAdapter - object of DrawingAdapterI
     */

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        double x = getX();
        double y = getY();
        
        Map<String, String> attributes = this.getAttributes();
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        double height = Double.parseDouble(attributes.get(AttributeLabel.HEIGHT.getLabel()));
        
        drawingAdapter.setFillColor(attributes.get(AttributeLabel.FILL_COLOR.getLabel()));
        drawingAdapter.setStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));
        drawingAdapter.setLineWidth(Double.parseDouble(attributes.get(AttributeLabel.STROKE_WIDTH.getLabel())));

        drawingAdapter.drawRectangle(x, y, width, height);
    }
}

