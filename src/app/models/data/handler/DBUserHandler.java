package app.models.data.handler;

import app.database.DBUser;
import app.models.User;

public class DBUserHandler implements Insert<User> {

    private final DBUser dbUser;

    public DBUserHandler() {
        this.dbUser = new DBUser();
    }

    @Override
    public boolean insert(User user) {
        return dbUser.create(user);
    }
}
