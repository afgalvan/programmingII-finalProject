package app.views;

import java.util.LinkedHashMap;
import lombok.val;

public class TerminalView {

    public void init() {
        val mainOptions = new LinkedHashMap<String, Runnable>();

        mainOptions.put("Opcion 1", this::option1);
        mainOptions.put("Opcion 2", this::option2);
        mainOptions.put("", this::pass);
        mainOptions.put("Salir", this::exit);

        val mainMenu = new Menu("Digitalización de procesos", mainOptions);
        while (true) {
            mainMenu.display();
        }
    }

    public void pass() {}

    public void exit() {
        System.out.println("Adios mamaguebo");
        System.exit(0);
    }

    public void option1() {
        System.out.println("Opción 1");
    }

    public void option2() {
        val option2Options = new LinkedHashMap<String, Runnable>();

        option2Options.put("Subopción 1", this::option1);
        option2Options.put("", this::pass);
        option2Options.put("Volver", this::pass);

        val subMenu = new Menu(option2Options);
        subMenu.display();
    }
}
