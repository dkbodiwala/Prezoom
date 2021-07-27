package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class StrokeColorTest {
    StrokeColor strokeColor;

    @Test
    public void testDataAndLabel() {
        strokeColor = new StrokeColor("#AA1234");
        assertEquals("StrokeColor attribute data not set properly.",
                "#AA1234", strokeColor.getData());
        assertEquals("StrokeColor attribute label not set properly.",
                AttributeLabel.STROKE_COLOR.getLabel(), strokeColor.getLabel());
    }

    @Test
    public void testDefaultData() {
        strokeColor = new StrokeColor();
        assertEquals("StrokeColor attribute default data not set properly.",
                strokeColor.DEFAULT_DATA, strokeColor.getData());
    }
}
