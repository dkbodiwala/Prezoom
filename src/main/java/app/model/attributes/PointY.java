package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents point Y attribute.
 * The value of this attribute determines point Y coordinate of line.
 * If no data is provided constructor, then the default value will be 100.
 */

public class PointY extends Attributes {

    public static final String DEFAULT_DATA = "0";

    
    /**
     * constructor with one parameter that setup the attributes constructor with label and data;
     * @param data
     */

    public PointY(String data) {
        super(AttributeLabel.POINT_Y.getLabel(), data);
    }

     /**
     * default constructor with data value 0;
     */
    
    public PointY() {
        this(DEFAULT_DATA);
    }    
}
