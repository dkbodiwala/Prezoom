package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Y position attribute.
 * The value of this attribute determines the object's Y position on the sheet.
 * If no data is provided constructor, then the default value will be 50.
 */

public class YPosition extends Attributes {

    public static final String DEFAULT_DATA = "50";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for YPosition;
     * @param data
     */

    public YPosition(String data) {
        super(AttributeLabel.Y_POSITION.getLabel(), data);
    }

     /**
     * default constructor with data value is 50;
     */

    public YPosition() {
        this(DEFAULT_DATA);
    }
}
