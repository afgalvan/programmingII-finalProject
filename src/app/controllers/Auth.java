package app.controllers;

public interface Auth {
    DialogResponse logUser(String username, String password);

    DialogResponse registerUser(String username, String password, int permission);
}
