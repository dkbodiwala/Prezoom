package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Radius attribute.
 * The value of this attribute determines the circle's radius.
 * If no data is provided constructor, then the default value will be 50.
 */

public class Radius extends Attributes {

    public static final String DEFAULT_DATA = "50";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for Radius;
     * @param data
     */

    public Radius(String data) {
        super(AttributeLabel.RADIUS.getLabel(), data);
    }  

     /**
     * default constructor with data value for Radius = 50;
     */
    
    
    public Radius() {
        this(DEFAULT_DATA);
    }
}
