package app.main;

import app.views.ProceedingRegister;
import app.views.TerminalView;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        new TerminalView().init();
    }
}
