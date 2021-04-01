package app.controllers;

import app.models.User;
import app.services.Response;
import app.services.UserService;
import lombok.Getter;

@Getter
public class UserController {

    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public String post(User user) {
        Response<User> res = userService.create(user);
        if (res.isError()) {
            return "No se pudo registra el usuario.";
        }
        return "Usuario registrado con éxito.";
    }

    public User get(User user) {
        Response<User> res = userService.read(user);
        if (res.isError()) {
            return null;
        }
        return res.getData();
    }
}
