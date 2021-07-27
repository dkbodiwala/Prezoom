package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Width attribute.
 * The value of this attribute determines the object's width.
 * If no data is provided constructor, then the default value will be 100.
 */

public class Width extends Attributes {

    public static final String DEFAULT_DATA = "100";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for width;
     * @param data
     */
    

    public Width(String data) {
        super(AttributeLabel.WIDTH.getLabel(), data);
    }

      /**
     * default constructor with data value for width = 100;
     */

    public Width() {
        this(DEFAULT_DATA);
    }
}
