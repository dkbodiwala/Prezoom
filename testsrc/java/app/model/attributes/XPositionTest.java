package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class XPositionTest {
    XPosition xPosition;

    @Test
    public void testDataAndLabel() {
        xPosition = new XPosition("67");
        assertEquals("XPosition attribute data not set properly.", "67", xPosition.getData());
        assertEquals("XPosition attribute label not set properly.",
                AttributeLabel.X_POSITION.getLabel(), xPosition.getLabel());
    }

    @Test
    public void testDefaultData() {
        xPosition = new XPosition();
        assertEquals("XPosition attribute default data not set properly.",
                xPosition.DEFAULT_DATA, xPosition.getData());
    }
}
