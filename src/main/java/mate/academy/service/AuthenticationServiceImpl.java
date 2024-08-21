package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info(String.format("Login method called with login: %s", login));
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.error("Authentication failed: Username or password are incorrect");
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.info("User successfully logged in with userId: " + user.getUserId());
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        user.setUserId(2L);
        logger.info("User found with login: " + login + " and userId: " + user.getUserId());
        return user;
    }
}
