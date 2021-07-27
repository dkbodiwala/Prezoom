package app.interfaces;

/**
* @author Team Alfa
* @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
*
* Class : This class represents the ObjectFactory Interface.
* This interface that initiates the instance of each object(e.g. Rectangle, circle,TextArea..)
 */

public interface ObjectFactoryI {
    ObjectsI makeCircle(String x, String y);

    ObjectsI makeLine(String x, String y);

    ObjectsI makeRectangle(String x, String y);

    ObjectsI makePlainText(String x, String y);

    ObjectsI makeTextArea(String x, String y);

    ObjectsI makeImage(String x, String y);
}