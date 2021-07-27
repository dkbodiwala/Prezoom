package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class HeightTest {
    Height height;

    @Test
    public void testDataAndLabel() {
        height = new Height("55");
        assertEquals("Height attribute data not set properly.", "55", height.getData());
        assertEquals("Height attribute label not set properly.",
                AttributeLabel.HEIGHT.getLabel(), height.getLabel());
    }

    @Test
    public void testDefaultData() {
        height = new Height();
        assertEquals("Height attribute default data not set properly.",
                height.DEFAULT_DATA, height.getData());
    }
}
