package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents End X attribute.
 * The value of this attribute determines end X coordinate of line.
 * If no data is provided constructor, then the default value will be 100.
 */

public class EndX extends Attributes {

    public static final String DEFAULT_DATA = "100";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for EndX;
     * @param data
     */

    public EndX(String data) {
        super(AttributeLabel.END_X.getLabel(), data);

    }

    /**
     * default constructor with data value 100;
     */

    public EndX() {
        this(DEFAULT_DATA);
    }
}
