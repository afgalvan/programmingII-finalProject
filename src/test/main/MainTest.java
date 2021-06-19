package test.main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.OrderedRunner;

@RunWith(OrderedRunner.class)
public class MainTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeClass
    public static void setUpOutput() {
        /*testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));*/
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterClass
    public static void restoreSystemOutput() {
        //System.setOut(systemOut);
    }

    @Test
    public void shouldPrintOnTerminal() {
        //Main.main(null);
        //assertEquals("", getOutput());
    }
}
