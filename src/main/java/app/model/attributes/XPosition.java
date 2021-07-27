package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents X position attribute.
 * The value of this attribute determines the object's X position on the sheet.
 * If no data is provided constructor, then the default value will be 50.
 */

public class XPosition extends Attributes {

    public static final String DEFAULT_DATA = "50";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for XPosition;
     * @param data
     */

    public XPosition(String data) {
        super(AttributeLabel.X_POSITION.getLabel(), data);
    }

     /**
     * default constructor with data value is 50;
     */

    public XPosition() {
        this(DEFAULT_DATA);
    }
}
