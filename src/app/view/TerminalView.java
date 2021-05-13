package app.view;

import lombok.val;

public class TerminalView {

    public void init() {
        val loginMenu = new LoginMenu();
        while (true) {
            loginMenu.display();
        }
    }
}
