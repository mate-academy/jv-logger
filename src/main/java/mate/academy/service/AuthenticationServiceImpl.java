package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("Method login called. Params: login={}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.warn("Failed login attempt for user: {}", login);
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.debug("User authenticated successfully: {}", login);
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        logger.debug("Dummy user data fetched: {}", user.getLogin());
        return user;
    }
}
