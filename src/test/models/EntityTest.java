package test.models;

import static org.junit.Assert.assertEquals;

import app.models.Entity;
import org.junit.Test;

public class EntityTest {

    @Test
    public void sampleModelTest() {
        Entity entity = new Entity("Bro");
        assertEquals("Bro", entity.getName());
    }
}
