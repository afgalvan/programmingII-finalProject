package app.view;

import app.controllers.AuthController;
import app.controllers.DialogResponse;
import app.models.Session;
import app.models.users.User;
import app.models.users.UserType;
import lombok.val;

import java.util.LinkedHashMap;

public class LoginMenu implements Menu {

    private MenuBuilder loginMenu;

    private final AuthController authController;

    public LoginMenu() {
        this.authController = new AuthController();
        initMenu();
    }

    @Override
    public void initMenu() {
        val loginMenuOptions = new LinkedHashMap<String, Runnable>();

        loginMenuOptions.put("Iniciar sesion", this::loginUser);
        loginMenuOptions.put("Registrar usuario", this::registerUser);
        loginMenuOptions.put("Ingresar como invitado", this::enterAsGuest);
        loginMenuOptions.put("", View::pass);
        loginMenuOptions.put("Salir", View::exit);

        loginMenu = new MenuBuilder("INICIO DE SESION", loginMenuOptions);
    }

    @Override
    public void display() {
        View.clear();
        loginMenu.display();
    }

    public void loginUser() {
        System.out.print("Ingrese el usuario: ");
        String username = View.scanner.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String password = View.nextPassword();

        DialogResponse<User> response = authController.loginUser(username, password);

        System.out.println("\n" + response.getMessage());
        View.waitForEnter();
        if (response.getType() != DialogResponse.ERROR_MESSAGE) {
            enterSession(response.getData());
        }
    }

    public void registerUser() {
        View.clear();
        System.out.println("REGISTRAR USUARIO");
        System.out.print("Ingrese un nombre: ");
        String username = View.scanner.nextLine();

        System.out.print("Ingrese una contraseña: ");
        String password = View.nextPassword();

        authController.registerUser(username, password, UserType.CO);
    }

    public void enterSession(User user) {
        new Dashboard(new Session(user)).display();
    }

    public void enterAsGuest() {
        new Dashboard(new Session(null)).display();
    }
}
