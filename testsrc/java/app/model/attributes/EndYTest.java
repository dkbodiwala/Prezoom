package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class EndYTest {
    EndY endY;

    @Test
    public void testDataAndLabel() {
        endY = new EndY("22");
        assertEquals("EndY attribute data not set properly.", "22", endY.getData());
        assertEquals("EndY attribute label not set properly.",
                AttributeLabel.END_Y.getLabel(), endY.getLabel());
    }

    @Test
    public void testDefaultData() {
        endY = new EndY();
        assertEquals("EndY attribute default data not set properly.",
                endY.DEFAULT_DATA, endY.getData());
    }
}
