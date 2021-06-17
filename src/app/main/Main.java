package app.main;

import java.security.Security;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Security.setProperty("crypto.policy", "unlimited");
    }
}
