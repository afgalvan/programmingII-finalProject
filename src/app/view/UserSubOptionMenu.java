package app.view;

import app.controllers.Auth;
import app.controllers.AuthController;
import app.controllers.UserController;
import app.models.users.UserType;
import java.util.LinkedHashMap;
import lombok.val;

public class UserSubOptionMenu implements Menu {

    private final Displayable last;
    private MenuBuilder registerMenu;

    public UserSubOptionMenu(Displayable last) {
        this.last = last;
        initMenu();
    }

    @Override
    public void initMenu() {
        val subOptions = new LinkedHashMap<String, Runnable>();

        subOptions.put("Crear", this::addUser);
        subOptions.put("Borrar", this::removeUser);
        subOptions.put("Editar", this::editUserMenu);
        subOptions.put("", View::pass);
        subOptions.put("Volver", last::display);

        registerMenu = new MenuBuilder("USUARIO", subOptions);
    }

    public void display() {
        while (true) {
            View.clear();
            registerMenu.display();
        }
    }

    public void addUser() {
        Auth authController = AuthController.getInstance();

        View.clear();
        System.out.println("CREACION DE USUARIO");
        System.out.print("Nombre: ");
        String name = View.scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = View.scanner.nextLine();

        System.out.println(authController.registerUser(name, password, UserType.CO));
    }

    public void removeUser() {
        UserController userController = UserController.getInstance();

        View.clear();
        System.out.println("REMOVER USUARIO");
        System.out.print("Ingrese el nombre del usuario a remover: ");
        String userName = View.scanner.nextLine();

        System.out.println(userController.deleteUserById(userName));
    }

    public void editUserMenu() {
        val editUserOptions = new LinkedHashMap<String, Runnable>();

        editUserOptions.put("Cambiar nombre de usuario", this::changeUsername);
        editUserOptions.put("Cambiar contraseña", this::changePassword);
        editUserOptions.put("", View::pass);
        editUserOptions.put("Volver", View::pass);

        val editOptionsMenu = new MenuBuilder("EDICION DE USUARIO", editUserOptions);
        View.clear();
        editOptionsMenu.display();
    }

    public void changeUsername() {
        // TODO: finish username changing.

        View.clear();
        System.out.println("CAMBIO DE NOMBRE DE USUARIO");
        System.out.print(
            "Ingrese el nombre del usuario al que desea cambiarle el nombre: "
        );
    }

    public void changePassword() {
        // TODO: finish password changing.
    }
}
