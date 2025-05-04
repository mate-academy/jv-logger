package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("method login was called with login: " + login + " password " + password);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.error("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        logger.info("method findByLogin was called with login: " + login);
        User user = new User(login, "1234");
        user.setUserId(2L);
        return user;
    }
}
