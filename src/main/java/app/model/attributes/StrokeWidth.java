package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Stroke Width attribute.
 * The value of this attribute determines stoke width of any object.
 * If no data is provided constructor, then the default value will be 1.
 */

public class StrokeWidth extends Attributes {

    public static final String DEFAULT_DATA = "1";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for stroke width;
     * @param data
     */

    public StrokeWidth(String data) {
        super(AttributeLabel.STROKE_WIDTH.getLabel(), data);
    }

    /**
     * default constructor with data value of stroke width is 1;
     */

    public StrokeWidth() {
        this(DEFAULT_DATA);
    }
}
