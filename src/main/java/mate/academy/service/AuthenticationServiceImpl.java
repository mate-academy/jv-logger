package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.debug("login() - start. Params: login = {}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.error("Login failed for user '{}'. Incorrect username or password.", login);
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.info("User '{}' authenticated successfully.", login);
        logger.debug("login() - end. User: {}", user);
        return user;
    }

    private User findByLogin(String login) {
        logger.debug("findByLogin() - start. Params: login = {}", login);
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        logger.debug("findByLogin() - end. User: {}", user);
        return user;
    }
}
