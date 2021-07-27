package app.model.objects;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 * Enum Class: This enum class define the object type;   
 */

public enum ObjectType {
    CIRCLE("Circle"),
    IMAGE("Image"),
    LINE("Line"),
    PLAIN_TEXT("Text"),
    RECTANGLE("Rectangle"),
    TEXT_AREA("TextArea"),
    CAMERA("Camera");

    private String type;

    /**
     * this constructor set objecttype;
     * @param type
     */

    ObjectType(String type) {
        this.type = type;
    }

    /**
     * this sub-routine returns object type;
     * @return type;
     */

    public String getType() {
        return type;
    }
}
