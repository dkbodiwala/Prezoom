package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FontTest {
    Font font;

    @Test
    public void testDataAndLabel() {
        font = new Font("10");
        assertEquals("Font attribute data not set properly.", "10", font.getData());
        assertEquals("Font attribute label not set properly.",
                AttributeLabel.FONT.getLabel(), font.getLabel());
    }

    @Test
    public void testDefaultData() {
        font = new Font();
        assertEquals("Font attribute default data not set properly.",
                font.DEFAULT_DATA, font.getData());
    }
}
