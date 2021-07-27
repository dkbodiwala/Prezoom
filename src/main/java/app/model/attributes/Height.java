package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Height attribute.
 * The value of this attribute determines the object's Height.
 * If no data is provided constructor, then the default value will be 100.
 */

public class Height extends Attributes {

    public static final String DEFAULT_DATA = "100";

     /**
     * constructor with one parameter that setup the attributes constructor with label and data for Height;
     * @param data
     */

    public Height(String data) {
        super(AttributeLabel.HEIGHT.getLabel(), data);
        
    }

     /**
     * default constructor with data value for height = 100;
     */

    public Height() {
        this(DEFAULT_DATA);
    }
}
