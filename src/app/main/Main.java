package app.main;

import app.database.DBAccess;
import app.views.ProcessView;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        bro("");
        ProcessView processView = new ProcessView();
        System.out.print("\033\143");
        processView.view();
    }
}
