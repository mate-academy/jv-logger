package mate.academy.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;

public class AuthenticationServiceImpl implements AuthenticationService {
    private final Logger logger = Logger.getLogger(AuthenticationServiceImpl.class.getName());

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.log(Level.INFO, "Login user with login: [" + login + "]");
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        return user;
    }
}
