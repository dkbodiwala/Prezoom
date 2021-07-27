package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Enum Class : AttributeLabel Enum
 * This enum is used to store labels for all the attributes in the application.
 */

public enum AttributeLabel {
    END_X("End X"),
    FILL_COLOR("Fill color"),
    FONT("Font"),
    FONT_SIZE("FontSize"),
    HEIGHT("Height"),
    LENGTH("Length"),
    RADIUS("Radius"),
    SOURCE("Source"),
    STROKE_COLOR("Stroke color"),
    STROKE_WIDTH("Stroke width"),
    TEXT("Text"),
    TEXT_AREA("Text area"),
    WIDTH("Width"),
    X_POSITION("X position"),
    Y_POSITION("Y position"),
    ROTATION("Rotation"),
    POINT_X("Point X"),
    POINT_Y("Point Y"),
    END_Y("End Y");

    private String label;

    /**
     * constructor with one parameter;
     * @param label
     */

    AttributeLabel(String label) {
        this.label = label;
    }

    /**
     * sub-routines return the label;
     * @return label
     */

    public String getLabel() {
        return label;
    }
}
