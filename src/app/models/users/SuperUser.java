package app.models.users;

/**
 * Superuser who has complete control.
 */
public class SuperUser extends User {

    public SuperUser(String name, String password) {
        super(name, password);
    }
}
