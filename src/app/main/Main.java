package app.main;

import static java.awt.EventQueue.invokeLater;

import app.views.auth.AuthWindow;
import lombok.val;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        val view = new AuthWindow();

        invokeLater(() -> view.setVisible(true));
    }
}
