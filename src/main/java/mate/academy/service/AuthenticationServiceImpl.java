package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        //TODO: add corresponding log message about method login was called
        logger.info("login method was called. Login: " + login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        user.setUserId(2L);
        logger.info("findByLogin method was called. Login: " + login
                + ". User ID: " + user.getUserId());
        return user;
    }
}
