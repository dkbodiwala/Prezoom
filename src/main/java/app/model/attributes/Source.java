package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Source attribute.
 * The value of this attribute determines the source uri for the image.
 * If no data is provided constructor, then the default value will be "src/main/resources/alfa.png".
 */


public class Source extends Attributes {

    public static final String DEFAULT_DATA = "src/main/resources/alfa.png";

    
    /**
     * constructor with one parameter that setup the attributes constructor with label and data for source (Image);
     * @param data
     */


    public Source(String data) {
        super(AttributeLabel.SOURCE.getLabel(), data);
        
    }

     /**
     * default constructor with data value for souces (Image) = "src/main/resources/alfa.png";
     */
    

    public Source() {
        this(DEFAULT_DATA);
    }
}
