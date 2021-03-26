package test.main

import app.models.Entity
import org.junit.Assert.assertEquals
import org.junit.Test

class MainTest {
    @Test
    fun sampleTest() {
        val entity = Entity()
        entity.name = "Imported from java"
        assertEquals(entity.name, "Imported from java")
    }
}
