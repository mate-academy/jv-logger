package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);
    private static final String initialPassword = "1234";
    private static final String AUTH_EXCEPTION_MESSAGE = "1234";

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("login method was called. Params: login={}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException(AUTH_EXCEPTION_MESSAGE);
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, initialPassword);
        user.setUserId(2L);
        return user;
    }
}
