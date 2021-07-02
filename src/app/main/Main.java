package app.main;

import app.views.View;

import java.security.Security;

import static java.awt.EventQueue.invokeLater;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Security.setProperty("crypto.policy", "unlimited");
        invokeLater(View::new);
    }
}
