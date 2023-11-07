package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String METHOD_LOGIN_CALL_MESSAGE = "Method "
            + "login was called. Params: login={}";
    private static final String AUTHENTICATION_FAILURE_MESSAGE = "Username "
            + "or password are incorrect";
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info(METHOD_LOGIN_CALL_MESSAGE, login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException(AUTHENTICATION_FAILURE_MESSAGE);
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        user.setUserId(2L);
        return user;
    }
}
