package test.main

import app.main.Main
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.PrintStream
import kotlin.test.assertEquals
import java.io.ByteArrayOutputStream

class MainTest {
    private val systemOut: PrintStream = System.out
    private var testOut: ByteArrayOutputStream? = null

    @Before
    fun setUpOutput() {
        testOut = ByteArrayOutputStream()
        System.setOut(PrintStream(testOut))
    }

    fun getOutput(): String {
        return testOut.toString()
    }

    @After
    fun restoreSystemOutput() {
        System.setOut(systemOut)
    }

    @Test
    fun shouldPrintInTerminal() {
        Main.main(null)
        assertEquals("De locos\n", getOutput())
    }
}
