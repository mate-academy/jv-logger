package mate.academy.exception;

import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.AuthenticationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationException extends Throwable implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    public AuthenticationException(String message) {
        super(message);
    }

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.debug("Performing login for user {}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login,"1234");
        user.setUserId(2L);
        return user;
    }
}
