package app.model.objects;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.EndX;
import app.model.attributes.EndY;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 * Class: This class represents the Line object and sets the attributes required for the same. 
 */

public class Line extends Objects {

    public static final int DEFAULT_OFFSET = 100;

    /**
     * This constructor is used to add attributes and sets default value of the attributes of the Line object.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     * @param end_x - It is x-coordinates of end of the line on canvas.
     * @param end_y - It is y-coordinates of end of the line on canvas.
     */

    public Line(String x, String y, String end_x, String end_y) {
        super(x, y, ObjectType.LINE.getType());
        addAttribute(new EndX(end_x));
        addAttribute(new EndY(end_y));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    /**
     * This constructor overloads the constructor.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     */

    public Line(String x, String y) {
        this(x, y, String.valueOf(Double.parseDouble(x) + DEFAULT_OFFSET), String.valueOf(Double.parseDouble(y) + DEFAULT_OFFSET));
    }

    /**
     * This sub-routine is used to locate the object on the canvas.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas. 
     * @return boolean 
     */

    @Override
    public boolean locatedAt(double x, double y) {
        double start_x = getX();
        double start_y = getY();

        Map<String, String> attributes = this.getAttributes();
        double end_x = Double.parseDouble(attributes.get(AttributeLabel.END_X.getLabel()));
        double end_y = Double.parseDouble(attributes.get(AttributeLabel.END_Y.getLabel()));

        double i = Math.sqrt(Math.pow((x - start_x), 2) + Math.pow((y - start_y), 2));
        double j = Math.sqrt(Math.pow((x - end_x), 2) + Math.pow((y - end_y), 2));
        double k = Math.sqrt(Math.pow((start_x - end_x), 2) + Math.pow((start_x - end_y), 2));
        
        return i + j == k ? true : false;
    }

    /**
     * This sub-routine draws the Line using the drawingAdapter.
     * 
     * @param DrawingAdapterI drawingAdapter - object of DrawingAdapterI
     */

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        double x = getX();
        double y = getY();
                
        Map<String, String> attributes = this.getAttributes();
        double end_x = Double.parseDouble(attributes.get(AttributeLabel.END_X.getLabel()));
        double end_y = Double.parseDouble(attributes.get(AttributeLabel.END_Y.getLabel()));

        drawingAdapter.setLineWidth(Double.parseDouble(attributes.get(AttributeLabel.STROKE_WIDTH.getLabel())));
        drawingAdapter.setStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));

        drawingAdapter.drawLine(x, y, end_x, end_y);
    }
}

