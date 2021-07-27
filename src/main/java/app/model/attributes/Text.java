package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Text attribute.
 * The value of this attribute determines the text written on the sheet.
 * If no data is provided constructor, then the default value will be "Alfa".
 */

public class Text extends Attributes {

    public static final String DEFAULT_DATA = "Alfa";

     /**
     * constructor with one parameter that setup the attributes constructor with label and data for text;
     * @param data
     */


    public Text(String data) {
        super(AttributeLabel.TEXT.getLabel(), data);
    }

      /**
     * default constructor with data value of text is alfa;
     */



    public Text() {
        this(DEFAULT_DATA);
    }    
}
