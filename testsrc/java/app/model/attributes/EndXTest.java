package app.model.attributes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class EndXTest {
    EndX endX;

    @Test
    public void testDataAndLabel() {
        endX = new EndX("15");
        assertEquals("EndX attribute data not set properly.", "15", endX.getData());
        assertEquals("EndX attribute label not set properly.",
                AttributeLabel.END_X.getLabel(), endX.getLabel());
    }

    @Test
    public void testDefaultData() {
        endX = new EndX();
        assertEquals("EndX attribute default data not set properly.",
                endX.DEFAULT_DATA, endX.getData());
    }
}
