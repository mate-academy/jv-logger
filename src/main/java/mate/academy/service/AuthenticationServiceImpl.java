package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("Method login was called with login: " + login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.error("Authentication failed for login: " + login);
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.info("User logged in successfully with login: " + login);
        return user;
    }

    private User findByLogin(String login) {
        logger.info("Searching for user with login: " + login);
        throw new UnsupportedOperationException("Implement database connection to retrieve user");
    }
}
