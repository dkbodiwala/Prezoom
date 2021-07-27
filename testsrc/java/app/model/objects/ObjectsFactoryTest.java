package app.model.objects;

import app.interfaces.ObjectsI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.Assert.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ObjectsFactoryTest {

    ObjectFactory objectFactory;

    @BeforeAll
    public void setup() {
        objectFactory = new ObjectFactory();
    }

    @Test
    public void testMakeCircle() {
        ObjectsI circleObject = objectFactory.makeCircle("10", "10");
        assertTrue("Object factory did not create Circle.", circleObject instanceof Circle);
    }

    @Test
    public void testMakeLine() {
        ObjectsI lineObject = objectFactory.makeLine("10", "10");
        assertTrue("Object factory did not create Line.", lineObject instanceof Line);
    }

    @Test
    public void testMakeImage() {
        ObjectsI imageObject = objectFactory.makeImage("10", "10");
        assertTrue("Object factory did not create Image.", imageObject instanceof Image);
    }

    @Test
    public void testMakeRectangle() {
        ObjectsI rectangleObject = objectFactory.makeRectangle("10", "10");
        assertTrue("Object factory did not create Rectangle.", rectangleObject instanceof Rectangle);
    }

    @Test
    public void testMakeText() {
        ObjectsI plainTextObject = objectFactory.makePlainText("10", "10");
        assertTrue("Object factory did not create PlainText.", plainTextObject instanceof PlainText);
    }

    @Test
    public void testMakeTextArea() {
        ObjectsI textAreaObject = objectFactory.makeTextArea("10", "10");
        assertTrue("Object factory did not create TextArea.", textAreaObject instanceof TextArea);
    }
}
