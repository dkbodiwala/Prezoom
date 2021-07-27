package app.model.objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RectangleTest {
    Objects rectangle;

    @BeforeAll
    public void setup() {
        rectangle = new Rectangle("10", "20", "30", "40");
    }

    @Test
    public void testRectangleAndItsAttributes() {
        Map<String, String> attributes = rectangle.getAttributes();

        assertEquals("Rectangle does not have proper number of attributes.",
                attributes.size(), 7);
        assertEquals("Width attribute not set properly.",
                attributes.get("Width"), "30");
        assertEquals("Height attribute not set properly.",
                attributes.get("Height"), "40");
        assertEquals("X position attribute not set properly.",
                attributes.get("X position"), "10");
        assertEquals("Y position attribute not set properly.",
                attributes.get("Y position"), "20");
        assertEquals("Stroke width attribute not set properly.",
                attributes.get("Stroke width"), "1");
        assertEquals("Fill color attribute not set properly.",
                attributes.get("Fill color"), "#FF0000");
        assertEquals("Stroke color attribute not set properly.",
                attributes.get("Stroke color"), "#000000");
    }
}

