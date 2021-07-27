package app.model.objects;

import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 * Class: This class create the instance of all the Objects. 
 */


public class ObjectFactory implements ObjectFactoryI {


    /**
     * @param x,y;
     * @return object of Circle
     */

    public ObjectsI makeCircle(String x, String y) {
        return new Circle(x, y);
    }

    /**
     * @param x,y;
     * @return object of Line
     */

    public ObjectsI makeLine(String x, String y) {
        return new Line(x, y);
    }

    /**
     * @param x,y;
     * @return object of Rectangle
     */

    public ObjectsI makeRectangle(String x, String y) {
        return new Rectangle(x, y);
    }

    /**
     * @param x,y;
     * @return object of PlainText
     */

    public ObjectsI makePlainText(String x, String y) {
        return new PlainText(x, y);
    }

    /**
     * @param x,y;
     * @return object of TextArea
     */

    public ObjectsI makeTextArea(String x, String y) {
        return new TextArea(x, y);
    }

    /**
     * @param x,y;
     * @return object of Image
     */

    public ObjectsI makeImage(String x, String y) {
        return new Image(x, y);
    }
}