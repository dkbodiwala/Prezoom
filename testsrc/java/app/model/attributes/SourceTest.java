package app.model.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SourceTest {
    Source source;

    @Test
    public void testDataAndLabel() {
        source = new Source("src/test/image1.png");
        assertEquals("Source attribute data not set properly.",
                "src/test/image1.png", source.getData());
        assertEquals("Source attribute label not set properly.",
                AttributeLabel.SOURCE.getLabel(), source.getLabel());
    }

    @Test
    public void testDefaultData() {
        source = new Source();
        assertEquals("Source attribute default data not set properly.",
                source.DEFAULT_DATA, source.getData());
    }
}
