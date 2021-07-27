package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Font Size attribute.
 * The value of this attribute determines the size of the fonts.
 * If no data is provided constructor, then the default value will be 12.
 */

public class FontSize extends Attributes {

    public static final String DEFAULT_DATA = "12";

     /**
     * constructor with one parameter that setup the attributes constructor with label and data for Font Size;
     * @param data
     */

    public FontSize(String data) {
        super(AttributeLabel.FONT_SIZE.getLabel(), data);
        
    }

     /**
     * default constructor with data value for font size = 12;
     */

    public FontSize() {
        this(DEFAULT_DATA);
    }
}
