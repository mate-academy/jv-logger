package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger log = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        log.info("login method was called. Params : login = {}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        log.info("login method return. User = {}", user);
        return user;
    }

    private User findByLogin(String login) {
        log.info("findByLogin method was called. Params : login = {}", login);
        User user = new User(login, "1234");
        user.setUserId(2L);
        log.info("findByLogin method return. User = {}", user);
        return user;
    }
}
