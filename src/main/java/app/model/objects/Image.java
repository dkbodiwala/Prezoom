package app.model.objects;

import app.model.attributes.Width;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.Height;
import app.model.attributes.Source;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 * Class: This class represents the "Image" object and sets the attributes required for the same. 
 */

public class Image extends Objects {

    public static final String DEFAULT_SOURCE = "/alfa.png";
    public static final String DEFAULT_WIDTH = "100";
    public static final String DEFAULT_HEIGHT = "80";

    /**
     * This constructor is used to add attributes and sets default value of the attributes of the "Image" object.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     * @param source - Contains the file destination of the image.
     * @param width - It is width of the image.
     * @param height - It is height of the image.
     */

    public Image(String x, String y, String source, String width, String height) {
        super(x, y, ObjectType.IMAGE.getType());
        addAttribute(new Source(source));
        addAttribute(new Width(width));
        addAttribute(new Height(height));
    }

    /**
     * This constructor overloads the constructor.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     */

    public Image(String x, String y) {
        this(x, y, DEFAULT_SOURCE, DEFAULT_WIDTH, DEFAULT_HEIGHT);
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
     * This sub-routine adds the Image to canvas using the drawingAdapter.
     * 
     * @param DrawingAdapterI drawingAdapter - object of DrawingAdapterI
     */

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        double x = getX();
        double y = getY();
        
        Map<String, String> attributes = this.getAttributes();
        String url = attributes.get(AttributeLabel.SOURCE.getLabel());
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        double height = Double.parseDouble(attributes.get(AttributeLabel.HEIGHT.getLabel()));

        drawingAdapter.drawImage(url, x, y, width, height);
    }
}

