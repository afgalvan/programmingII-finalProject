package app.views.components.auth;

import app.controllers.Auth;
import app.controllers.AuthController;
import app.views.Window;
import lombok.Setter;

@Setter
public class RegisterForm extends AuthForm {

    private Auth authController;

    public RegisterForm(Window window) {
        super("Crear cuenta", window);
        this.authController = AuthController.getInstance();
    }


}
