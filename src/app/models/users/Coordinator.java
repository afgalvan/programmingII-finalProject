package app.models.users;

/**
 * User who has access to admin panel, but can't create new users.
 */
public class Coordinator extends User {

    public Coordinator(String name, String password) {
        super(name, password);
    }
}
