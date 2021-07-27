package app.model.objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LineTest {
    Objects line;

    @BeforeAll
    public void setup() {
        line = new Line("10", "20", "30", "40");
    }

    @Test
    public void testLineAndItsAttributes() {
        Map<String, String> attributes = line.getAttributes();

        assertEquals("Line does not have proper number of attributes.",
                attributes.size(), 7);
        assertEquals("X position attribute not set properly.",
                attributes.get("X position"), "10");
        assertEquals("Y position attribute not set properly.",
                attributes.get("Y position"), "20");
        assertEquals("End X attribute not set properly.",
                attributes.get("End X"), "30");
        assertEquals("End Y attribute not set properly.",
                attributes.get("End Y"), "40");
        assertEquals("Stroke width attribute not set properly.",
                attributes.get("Stroke width"), "1");
        assertEquals("Fill color attribute not set properly.",
                attributes.get("Fill color"), "#FF0000");
        assertEquals("Stroke color attribute not set properly.",
                attributes.get("Stroke color"), "#000000");
    }
}

