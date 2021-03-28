package app.main;

import app.views.ProcessView;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        ProcessView view = new ProcessView();
        view.view();
    }
}
