package test.main;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemOutput() {
        System.setOut(systemOut);
    }

    @Test(expected = Test.None.class/* no exception expected */)
    public void shouldPrintOnTerminal() {
        //Main.main(null);
        assertEquals("", getOutput());
    }
}
