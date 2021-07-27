package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class RadiusTest {
    Radius radius;

    @Test
    public void testDataAndLabel() {
        radius = new Radius("30");
        assertEquals("Radius attribute data not set properly.", "30", radius.getData());
        assertEquals("Radius attribute label not set properly.",
                AttributeLabel.RADIUS.getLabel(), radius.getLabel());
    }

    @Test
    public void testDefaultData() {
        radius = new Radius();
        assertEquals("Radius attribute default data not set properly.",
                radius.DEFAULT_DATA, radius.getData());
    }
}
