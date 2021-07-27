package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Length attribute.
 * The value of this attribute determines the object's Length.
 * If no data is provided constructor, then the default value will be 100.
 */

public class Length extends Attributes {

    public static final String DEFAULT_DATA = "100";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for Length;
     * @param data
     */
    
    public Length(String data) {
        super(AttributeLabel.LENGTH.getLabel(), data);
        
    }

     /**
     * default constructor with data value for length = 100;
     */
    
    public Length() {
        this(DEFAULT_DATA);
    }       
}