package mate.academy.service;

import java.util.logging.Logger;
import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = Logger.getLogger(AuthenticationServiceImpl
            .class.getName());

    @Override
    public User login(String login, String password) throws AuthenticationException {
        //TODO: add corresponding log message about method login was called
        logger.info("login() method was called with login: " + login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.warning("Authentication failed for user: " + login);
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        logger.fine("Created dummy user with ID: " + user.getUserId());
        return user;
    }
}
