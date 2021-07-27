package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class StrokeWidthTest {
    StrokeWidth strokeWidth;

    @Test
    public void testDataAndLabel() {
        strokeWidth = new StrokeWidth("40");
        assertEquals("StrokeWidth attribute data not set properly.", "40", strokeWidth.getData());
        assertEquals("StrokeWidth attribute label not set properly.",
                AttributeLabel.STROKE_WIDTH.getLabel(), strokeWidth.getLabel());
    }

    @Test
    public void testDefaultData() {
        strokeWidth = new StrokeWidth();
        assertEquals("StrokeWidth attribute default data not set properly.",
                strokeWidth.DEFAULT_DATA, strokeWidth.getData());
    }
}
