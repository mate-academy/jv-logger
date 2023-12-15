package mate.academy.service;

import mate.academy.Main;
import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(Main.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("login was called. Params: login = {}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.error("Username or password are incorrect");
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        logger.info("findByLogin was called. Params: login = {}", login);
        User user = new User(login, "1234");
        logger.info("new user was created. Params: login = {}", login);
        user.setUserId(2L);
        logger.info("user id was attributed");
        return user;
    }
}
