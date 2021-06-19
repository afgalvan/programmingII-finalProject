package app.main;

import static javax.swing.SwingUtilities.invokeLater;

import app.views.View;
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
