package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Font attribute.
 * The value of this attribute determines the font family of the text.
 * If no data is provided constructor, then the default value will be <TBD>.
 */

public class Font extends Attributes {

    public static final String DEFAULT_DATA = "";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for Font;
     * @param data
     */

    public Font(String data) {
        super(AttributeLabel.FONT.getLabel(), data);
        
    }

     /**
     * default constructor with no data value for font;
     */


    public Font() {
        this(DEFAULT_DATA);
    }
}
