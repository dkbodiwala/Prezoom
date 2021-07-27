package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FillColorTest {
    FillColor fillColor;

    @Test
    public void testDataAndLabel() {
        fillColor = new FillColor("25");
        assertEquals("FillColor attribute data not set properly.", "25", fillColor.getData());
        assertEquals("FillColor attribute label not set properly.",
                AttributeLabel.FILL_COLOR.getLabel(), fillColor.getLabel());
    }

    @Test
    public void testDefaultData() {
        fillColor = new FillColor();
        assertEquals("FillColor attribute default data not set properly.",
                fillColor.DEFAULT_DATA, fillColor.getData());
    }
}
