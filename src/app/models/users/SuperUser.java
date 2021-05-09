package app.models.users;

/**
 * Superuser who has complete control and access of the program.
 */
public class SuperUser extends User {

    public SuperUser(String name, String password) {
        super(name, password, null);
    }

    public SuperUser(String name, String password, String salt) {
        super(name, password, salt);
    }
}
