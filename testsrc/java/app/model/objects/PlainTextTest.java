package app.model.objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlainTextTest {
    Objects plainText;

    @BeforeAll
    public void setup() {
        plainText = new PlainText("10", "20", "It contains some text here.", "15");
    }

    @Test
    public void testPlainTextAndItsAttributes() {
        Map<String, String> attributes = plainText.getAttributes();

        assertEquals("PlainText does not have proper number of attributes.",
                attributes.size(), 8);
        assertEquals("X position attribute not set properly.",
                attributes.get("X position"), "10");
        assertEquals("Y position attribute not set properly.",
                attributes.get("Y position"), "20");
        assertEquals("Text attribute not set properly.",
                attributes.get("Text"), "It contains some text here.");
        assertEquals("FontSize attribute not set properly.",
                attributes.get("FontSize"), "15");
        assertEquals("Stroke width attribute not set properly.",
                attributes.get("Stroke width"), "1");
        assertEquals("Fill color attribute not set properly.",
                attributes.get("Fill color"), "#FF0000");
        assertEquals("Stroke color attribute not set properly.",
                attributes.get("Stroke color"), "#000000");
    }
}

