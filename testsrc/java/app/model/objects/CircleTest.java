package app.model.objects;

import app.model.attributes.Attributes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CircleTest {
    Objects circle;

    @BeforeAll
    public void setup() {
        circle = new Circle("9", "4", "50");
    }

    @Test
    public void testCircleAndItsAttributes() {
        Map<String, String> attributes = circle.getAttributes();

        assertEquals("Circle does not have proper number of attributes.",
                attributes.size(), 6);
        assertEquals("Radius attribute not set properly.",
                attributes.get("Radius"), "50");
        assertEquals("X position attribute not set properly.",
                attributes.get("X position"), "9");
        assertEquals("Y position attribute not set properly.",
                attributes.get("Y position"), "4");
        assertEquals("Stroke width attribute not set properly.",
                attributes.get("Stroke width"), "1");
        assertEquals("Fill color attribute not set properly.",
                attributes.get("Fill color"), "#FF0000");
        assertEquals("Stroke color attribute not set properly.",
                attributes.get("Stroke color"), "#000000");
    }
}
