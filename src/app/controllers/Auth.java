package app.controllers;

import app.models.users.User;
import app.models.users.UserType;

public interface Auth {
    DialogResponse<User> loginUser(String username, String password);

    DialogResponse<User> registerUser(
        String username,
        String password,
        UserType permission
    );
}
