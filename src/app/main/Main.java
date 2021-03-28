package app.main;

import app.views.ProcessView;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        ProcessView processView = new ProcessView();
        System.out.print("\033\143");
        processView.view();
    }
}
