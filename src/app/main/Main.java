package app.main;

import app.controllers.UserController;
import app.models.SuperUser;
import app.models.User;
import app.views.ProcessView;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        ProcessView processView = new ProcessView();
        processView.view();
        System.out.print("\033\143");
        User user = new SuperUser("Jorge2", "123");
        User user1 = new SuperUser("Jorge3", "321");
        UserController userController = new UserController();
        System.out.println(userController.post(user));
        System.out.println(userController.put(user, user1));
        System.out.println(userController.get(user1));
    }
}
