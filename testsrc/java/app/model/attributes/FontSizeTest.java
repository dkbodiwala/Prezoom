package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FontSizeTest {
    FontSize fontSize;

    @Test
    public void testDataAndLabel() {
        fontSize = new FontSize("25");
        assertEquals("FontSize attribute data not set properly.", "25", fontSize.getData());
        assertEquals("FontSize attribute label not set properly.",
                AttributeLabel.FONT_SIZE.getLabel(), fontSize.getLabel());
    }

    @Test
    public void testDefaultData() {
        fontSize = new FontSize();
        assertEquals("FontSize attribute default data not set properly.",
                fontSize.DEFAULT_DATA, fontSize.getData());
    }
}
