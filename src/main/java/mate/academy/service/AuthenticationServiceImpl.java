package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.debug("Method login was called. Params: login = {} ", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.debug("Method login worked successfully. Params: login = {}", login);
        return user;
    }

    private User findByLogin(String login) {
        logger.debug("Method findByLogin was called. Params: {}", login);
        User user = new User(login, "1234");
        user.setUserId(2L);
        logger.debug("Method findByLogin worked successfully. Params: {}", login);
        return user;
    }
}
