package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Fill Color attribute.
 * The value of this attribute determines the color filled in the object's.
 * If no data is provided constructor, then the default value will be #FF0000.
 */

public class FillColor extends Attributes {

    public static final String DEFAULT_DATA = "#FF0000";

   /**
     * constructor with one parameter that setup the attributes constructor with label and data for Fill color;
     * @param data
     */

    public FillColor(String data) {
        super(AttributeLabel.FILL_COLOR.getLabel(), data);
    }

    
     /**
     * default constructor with data value of fill color is #FF0000;
     */

    public FillColor() {
        this(DEFAULT_DATA);
    }    
}
