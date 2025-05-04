package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("Method `login` was called. Params: login = {}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        user.setUserId(2L);
        logger.info("Method `findByLogin` was called"
                        + " user with login = {}", login
                        + " was find in DB");
        return user;
    }
}
