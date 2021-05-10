package app.controllers;

import app.models.users.UserType;

public interface Auth {
    DialogResponse logUser(String username, String password);

    DialogResponse registerUser(
        String username,
        String password,
        UserType permission
    );
}
