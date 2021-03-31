package app.models.data.handler;

import app.database.UserRepository;
import app.models.User;

public class DBUserHandler implements Insert<User> {

    private final UserRepository userRepository;

    public DBUserHandler() {
        this.userRepository = new UserRepository();
    }

    @Override
    public boolean insert(User user) {
        return userRepository.create(user);
    }
}
