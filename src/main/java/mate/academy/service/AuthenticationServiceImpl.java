package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationService.class);
    private static final String METHOD_CALL_MSG = "login method was called. Params: login={}";
    private static final String AUTH_ERROR_MSG = "Username or password are incorrect";

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info(METHOD_CALL_MSG, login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException(AUTH_ERROR_MSG);
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        return user;
    }
}

