package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TextAreaTest {
    TextArea textArea;

    @Test
    public void testDataAndLabel() {
        textArea = new TextArea("Alpha project under development.");
        assertEquals("TextArea attribute data not set properly.",
                "Alpha project under development.", textArea.getData());
        assertEquals("TextArea attribute label not set properly.",
                AttributeLabel.TEXT_AREA.getLabel(), textArea.getLabel());
    }

    @Test
    public void testDefaultData() {
        textArea = new TextArea();
        assertEquals("TextArea attribute default data not set properly.",
                textArea.DEFAULT_DATA, textArea.getData());
    }
}
