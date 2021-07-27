package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TextTest {
    Text text;

    @Test
    public void testDataAndLabel() {
        text = new Text("Alpha Group Testing");
        assertEquals("Text attribute data not set properly.", "Alpha Group Testing", text.getData());
        assertEquals("Text attribute label not set properly.",
                AttributeLabel.TEXT.getLabel(), text.getLabel());
    }

    @Test
    public void testDefaultData() {
        text = new Text();
        assertEquals("Text attribute default data not set properly.",
                text.DEFAULT_DATA, text.getData());
    }
}
