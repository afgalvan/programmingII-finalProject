package app.models.users;

/**
 * Representa al usuario el cual puede tener acceso al panel de
 * administracion, pero no puede crear nuevos usuarios.
 */
public class Coordinator extends User {

    public Coordinator(String name, String password) {
        super(name, password);
    }
}
