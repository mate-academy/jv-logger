package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOGGER = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        LOGGER.info(String.format("start AuthenticationServiceImpl.login(%s, ****)", login));
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        long userId = 2L;
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        LOGGER.info("set user ID - user login: {}; user id: {}", login, userId);
        user.setUserId(userId);
        return user;
    }
}
