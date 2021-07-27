package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class WidthTest {
    Width width;

    @Test
    public void testDataAndLabel() {
        width = new Width("55");
        assertEquals("Width attribute data not set properly.", "55", width.getData());
        assertEquals("Width attribute label not set properly.",
                AttributeLabel.WIDTH.getLabel(), width.getLabel());
    }

    @Test
    public void testDefaultData() {
        width = new Width();
        assertEquals("Width attribute default data not set properly.",
                width.DEFAULT_DATA, width.getData());
    }
}
