package app.models.users;

/**
 * Representa al usuario super administrador.
 * Tiene todas las funcionalidades.
 */
public class SuperUser extends User {

    public SuperUser(String name, String password) {
        super(name, password);
    }
}
