package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class YPositionTest {
    YPosition yPosition;

    @Test
    public void testDataAndLabel() {
        yPosition = new YPosition("82");
        assertEquals("YPosition attribute data not set properly.", "82", yPosition.getData());
        assertEquals("YPosition attribute label not set properly.",
                AttributeLabel.Y_POSITION.getLabel(), yPosition.getLabel());
    }

    @Test
    public void testDefaultData() {
        yPosition = new YPosition();
        assertEquals("YPosition attribute default data not set properly.",
                yPosition.DEFAULT_DATA, yPosition.getData());
    }
}
