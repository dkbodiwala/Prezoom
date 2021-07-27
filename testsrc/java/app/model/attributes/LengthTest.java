package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LengthTest {
    Length length;

    @Test
    public void testDataAndLabel() {
        length = new Length("80");
        assertEquals("Length attribute data not set properly.", "80", length.getData());
        assertEquals("Length attribute label not set properly.",
                AttributeLabel.LENGTH.getLabel(), length.getLabel());
    }

    @Test
    public void testDefaultData() {
        length = new Length();
        assertEquals("Length attribute default data not set properly.",
                length.DEFAULT_DATA, length.getData());
    }
}
