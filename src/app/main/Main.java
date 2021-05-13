package app.main;

import app.view.TerminalView;
import java.security.Security;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Security.setProperty("crypto.policy", "unlimited");
        new TerminalView().init();
    }
}
