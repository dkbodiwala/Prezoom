package app.model.attributes;

import app.interfaces.AttributesI;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents the parent Attribute class.
 * Any attribute present in the application has to extend this class.
 */

public class Attributes implements AttributesI {
    private String data;
    private String label;

    /**
     * constructor with two parameters; 
     * @param label
     * @param data
     */

    public Attributes(String label, String data) {
        this.label = label;
        this.data = data;
    }

    /**
     * sub-routines for setting attributes data;
     * @param data
     */

    public void setData(String data) {
        this.data = data;
    }

    /**
     * this sub-routine return the data of attribute;
     * @return data 
     */

    @Override
    public String getData() {
        return data;
    }

    /**
     * sub-routines returns the label;
     * @return label;
     */

    @Override
    public String getLabel() {
        return label;
    }
}


