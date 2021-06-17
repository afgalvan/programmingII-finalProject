package app.main;

import app.views.View;
import static java.awt.EventQueue.invokeLater;
import java.security.Security;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Security.setProperty("crypto.policy", "unlimited");
        invokeLater(View::new);
    }
}
