package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    public static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);
    private static final char [] PASSWORD = { '1','2','3','4' };
    private static final String INCORRECT_DATA = "Username or password are incorrect";

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("Login is: " + login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException(INCORRECT_DATA);
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, String.valueOf(PASSWORD));
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        return user;
    }
}
