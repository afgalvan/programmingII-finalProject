package app.controllers;

import app.models.User;
import app.services.Response;
import app.services.UserService;
import lombok.Getter;

import java.util.List;

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

    public List<User> gets() {
        Response<List<User>> res  = userService.readAll();
        if (res.isError()) {
            return null;
        }
        return res.getData();
    }

    public User get(User user) {
        Response<User> res = userService.read(user);
        if (res.isError()) {
            return null;
        }
        return res.getData();
    }

    public String delete(User user) {
        Response<User> res = userService.delete(user);
        if (res.isError()) {
            return "Error inesperado.";
        }
        return "Usuario eliminado con exito.";
    }

    public String put(User original, User newData) {
        Response<User> res = userService.update(original, newData);
        if (res.isError()) {
            return "No se pudo modificar el usuario.";
        }
        return "Datos del usuario actualizados";
    }
}
