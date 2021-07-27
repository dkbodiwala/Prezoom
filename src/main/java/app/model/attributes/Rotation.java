package app.model.attributes;

public class Rotation extends Attributes {

    public static final String DEFAULT_DATA = "0";

    /**
     * constructor with one parameter that setup the attributes constructor with label and data for Radius;
     * @param data
     */

    public Rotation(String data) {
        super(AttributeLabel.ROTATION.getLabel(), data);
    }  

     /**
     * default constructor with data value for Radius = 50;
     */
    
    
    public Rotation() {
        this(DEFAULT_DATA);
    }
}
