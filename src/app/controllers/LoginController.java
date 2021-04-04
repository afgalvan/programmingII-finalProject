package app.controllers;

import app.models.DialogResponse;
import javax.swing.*;

public class LoginController {

    public void encryptPassword() {}

    public boolean areValidCredentials(String name, String password) {
        return true;
    }

    public DialogResponse logUser(String name, String password) {
        return new DialogResponse(
            "Inicio de sesion",
            "Bienvenido " + name + "!",
            JOptionPane.DEFAULT_OPTION
        );
    }

    public DialogResponse registerUser(String name, String password) {
        return new DialogResponse(
            "Registro",
            "El usuario " + name + " se registro con exito",
            JOptionPane.DEFAULT_OPTION
        );
    }
}
