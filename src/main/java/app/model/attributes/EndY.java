package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents End Y attribute.
 * The value of this attribute determines end Y coordinate of line.
 * If no data is provided constructor, then the default value will be 100.
 */

public class EndY extends Attributes {

    public static final String DEFAULT_DATA = "100";

    
    /**
     * constructor with one parameter that setup the attributes constructor with label and data;
     * @param data
     */

    public EndY(String data) {
        super(AttributeLabel.END_Y.getLabel(), data);
    }

     /**
     * default constructor with data value 100;
     */
    
    public EndY() {
        this(DEFAULT_DATA);
    }    
}
