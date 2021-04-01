package app.main;

import app.controllers.UserController;
import app.models.Coordinator;
import app.views.ProcessView;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        ProcessView processView = new ProcessView();
        processView.view();
        System.out.print("\033\143");
        Coordinator coordinator = new Coordinator("Andrés", "123");
        UserController userController = new UserController();
        System.out.println(userController.get(coordinator));
    }
}
