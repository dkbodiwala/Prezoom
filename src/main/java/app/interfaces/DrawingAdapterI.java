package app.interfaces;

/**
* @author Team Alfa
* @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
*
* This is a DrawingAdapter Interface.
 * It has declaration of setter methods for stroke Color, fill color, font and linewidhth. 
 * It has declaration of transformation and drawing objects methods on presentation mode.
 */

public interface DrawingAdapterI {
    void setStrokeColor(String color);

    void setFillColor(String color);

    void setFont(String font);

    void setLineWidth(double width);

    void reset();

    void drawCamera(double x, double y, double width, double height, double rotation, double px, double py);
    
    void drawRectangle(double x, double y, double width, double height);

    void drawCircle(double x, double y, double radius);

    void drawLine(double start_x, double start_y, double end_x, double end_y);

    void drawText(String text, double x, double y, double width);

    void drawTextArea(String text, double x, double y, double width, double height);

    void drawImage(String url, double x, double y, double width, double height);
}