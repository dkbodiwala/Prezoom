package app.model.objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ImageTest {
    Objects image;

    @BeforeAll
    public void setup() {
        image = new Image("14", "3", "src/main/resources/alfa.png" ,"100" ,"200" );
    }

    @Test
    public void testImageAndItsAttributes() {
        Map<String, String> attributes = image.getAttributes();

        assertEquals("Image does not have proper number of attributes.",
                attributes.size(), 5);
        assertEquals("Source attribute not set properly.",
                attributes.get("Source"), "src/main/resources/alfa.png");
        assertEquals("X position attribute not set properly.",
                attributes.get("X position"), "14");
        assertEquals("Y position attribute not set properly.",
                attributes.get("Y position"), "3");
        assertEquals("Width attribute not set properly.",
                attributes.get("Width"), "100");
        assertEquals("Height attribute not set properly.",
                attributes.get("Height"), "200");
    }
}

