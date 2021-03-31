package app.services;

import app.database.UserRepository;
import app.models.User;

public class UserService implements Insert<User> {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    @Override
    public boolean insert(User user) {
        return userRepository.create(user);
    }
}
