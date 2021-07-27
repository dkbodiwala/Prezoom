package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Text Area attribute.
 * The value of this attribute determines the text present in the text area.
 * If no data is provided constructor, then the default value will be "Alfa".
 */

public class TextArea extends Attributes {

    public static final String DEFAULT_DATA = "Alfa";

     /**
     * constructor with one parameter that setup the attributes constructor with label and data for textarea;
     * @param data
     */


    public TextArea(String data) {
        super(AttributeLabel.TEXT_AREA.getLabel(), data);
    }

    /**
     * default constructor with data value of textarea is alfa;
     */


    public TextArea() {
        this(DEFAULT_DATA);
    }    
}
