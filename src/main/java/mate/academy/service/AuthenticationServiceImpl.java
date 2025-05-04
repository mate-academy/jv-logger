package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOGGER = LogManager
            .getLogger(AuthenticationServiceImpl.class.getName());

    @Override
    public User login(String login, String password) throws AuthenticationException {
        User user = findByLogin(login);
        LOGGER.info("Method login was called. Params: Login: {}", login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        user.setUserId(2L);
        LOGGER.info("Method findByLogin was called."
                + " Params: User: {}, UserId: {}", user, user.getUserId());
        return user;
    }
}
