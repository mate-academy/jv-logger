package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("login() called with: {}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.error("User or password are incorrect");
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.info("User {} successfully logged in", login);
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        return user;
    }
}
