package app.controllers;

import app.models.users.UserType;

public interface Auth {
    DialogResponse loginUser(String username, String password);

    DialogResponse registerUser(String username, String password, UserType permission);
}
