package test.models;

import app.models.Entity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityTest {
    @Test
    public void sampleModelTest() {
        Entity entity = new Entity();
        entity.setName("Bro");
        assertEquals("Bro", entity.getName());
    }
}
