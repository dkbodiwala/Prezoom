package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Point X attribute.
 * The value of this attribute determines point X coordinate of line.
 * If no data is provided constructor, then the default value will be 100.
 */

public class PointX extends Attributes {

    public static final String DEFAULT_DATA = "0";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for PointX;
     * @param data
     */

    public PointX(String data) {
        super(AttributeLabel.POINT_X.getLabel(), data);

    }

    /**
     * default constructor with data value 0;
     */

    public PointX() {
        this(DEFAULT_DATA);
    }
}
