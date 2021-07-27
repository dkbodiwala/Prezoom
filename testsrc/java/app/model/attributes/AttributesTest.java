package app.model.attributes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AttributesTest {

    Attributes attributes;

    @BeforeAll
    public void setup() {
        attributes = new Attributes("Radius", "50");
    }

    @Test
    public void testGetData() {
        assertEquals("Attributes data not set properly.", attributes.getData(), "50");
    }

    @Test
    public void testGetLabel() {
        assertEquals("Attributes data not set properly.", attributes.getLabel(), "Radius");
    }
}
