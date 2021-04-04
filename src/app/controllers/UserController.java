package app.controllers;

import app.models.User;
import app.services.Response;
import app.services.UserService;
import java.util.List;
import lombok.Getter;

@Getter
public class UserController {

    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    // POST
    public String postUser(User user) {
        Response<User> res = userService.create(user);
        if (res.isError()) {
            return "No se pudo registra el usuario.";
        }
        return "Usuario registrado con éxito.";
    }

    // GET
    public List<User> getUsers() {
        Response<List<User>> res = userService.readAll();
        if (res.isError()) {
            return null;
        }
        return res.getData();
    }

    // GET
    public User getUserById(String username) {
        Response<User> res = userService.read(username);
        if (res.isError()) {
            return null;
        }
        return res.getData();
    }

    // POST
    public String deleteUserById(String username) {
        Response<User> res = userService.delete(username);
        if (res.isError()) {
            return "Error inesperado.";
        }
        return "Usuario eliminado con exito.";
    }

    // PUT
    public String updateUserById(String username, User newData) {
        Response<User> res = userService.update(username, newData);
        if (res.isError()) {
            return "No se pudo modificar el usuario.";
        }
        return "Datos del usuario actualizados";
    }
}
