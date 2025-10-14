package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.debug("Method login() was called. Params: login={}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.warn("Authentication failed for login={}", login);
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.info("User login successful. login={}, userId={}", login, user.getUserId());
        return user;
    }

    private User findByLogin(String login) {
        logger.debug("Fetching user from DB (mocked). login={}", login);
        User user = new User(login, "1234");
        user.setUserId(2L);
        logger.debug("User fetched successfully. login={}, userId={}", login, user.getUserId());
        return user;
    }
}
