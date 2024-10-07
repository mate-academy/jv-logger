package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("Login method called with login: {}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.warn("Login failed for user: {}", login);
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.info("User successfully logged in: {}", login);
        return user;
    }

    private User findByLogin(String login) {
        logger.debug("Finding user by login: {}", login);
        User user = new User(login, "1234");
        user.setUserId(2L);
        return user;
    }
}
