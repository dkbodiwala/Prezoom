package app.model.objects;

import app.model.attributes.Text;
import app.model.attributes.Width;
import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.FillColor;
import app.model.attributes.FontSize;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;
import java.util.Map;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 * Class: This class represents the Plain Text object and sets the attributes required for the same. 
 */

public class PlainText extends Objects {

    public static final String DEFAULT_TEXT = "Alfa";
    public static final String DEFAULT_FONTSIZE = "10";

    /**
    * This constructor is used to add attributes and sets default value of the attributes of the Plain Text object.
    * @param x - It is x-coordinates on canvas.
    * @param y - It is y-coordinates on canvas.
    * @param text - It is the text input.
    * @param fontsize - It is the size of the text(Font).
    */

    public PlainText(String x, String y, String text, String fontsize) {
        super(x, y, ObjectType.PLAIN_TEXT.getType());
        addAttribute(new Text(text));
        addAttribute(new FontSize(fontsize));
        addAttribute(new Width());
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

     /**
     * This constructor overloads the constructor.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     */

    public PlainText(String x, String y) {
        this(x, y, DEFAULT_TEXT, DEFAULT_FONTSIZE);
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
        double height = Double.parseDouble(attributes.get(AttributeLabel.FONT_SIZE.getLabel()));

        return (x >= xPos && x <= (xPos + width) && y >= yPos && y <= (yPos + height)) ? true : false;
    }

    /**
     * This sub-routine draws the PlainText using the drawingAdapter.
     * 
     * @param DrawingAdapterI drawingAdapter - object of DrawingAdapterI
     */

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        double x = getX();
        double y = getY();
        
        Map<String, String> attributes = this.getAttributes();
        String text = attributes.get(AttributeLabel.TEXT.getLabel());
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        
        drawingAdapter.setFont(attributes.get(AttributeLabel.FONT.getLabel()));
        drawingAdapter.setFillColor(attributes.get(AttributeLabel.FILL_COLOR.getLabel()));
        drawingAdapter.setStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));
        drawingAdapter.setLineWidth(Double.parseDouble(attributes.get(AttributeLabel.STROKE_WIDTH.getLabel())));

        drawingAdapter.drawText(text, x, y, width);
    }
}

