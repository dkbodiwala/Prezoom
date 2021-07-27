package app.model.objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TextAreaTest {
    Objects textArea;

    @BeforeAll
    public void setup() {
        textArea = new TextArea("30", "35", "This project is awesome." , "50" , "70");
    }

    @Test
    public void testTextAreaAndItsAttributes() {
        Map<String, String> attributes = textArea.getAttributes();

        assertEquals("TextArea does not have proper number of attributes.",
                attributes.size(), 8);
        assertEquals("Text attribute not set properly.",
                attributes.get("Text"), "This project is awesome.");
        assertEquals("Width attribute not set properly.",
                attributes.get("Width"), "50");
        assertEquals("Height attribute not set properly.",
                attributes.get("Height"), "70");
        assertEquals("X position attribute not set properly.",
                attributes.get("X position"), "30");
        assertEquals("Y position attribute not set properly.",
                attributes.get("Y position"), "35");
        assertEquals("Stroke width attribute not set properly.",
                attributes.get("Stroke width"), "1");
        assertEquals("Fill color attribute not set properly.",
                attributes.get("Fill color"), "#FF0000");
        assertEquals("Stroke color attribute not set properly.",
                attributes.get("Stroke color"), "#000000");
    }
}

