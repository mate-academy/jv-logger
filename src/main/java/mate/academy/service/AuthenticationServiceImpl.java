package mate.academy.service;

import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) {
        logger.info("Method login was called. Params: login={}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.warn("Username or password are incorrect. Params: login={}", login);
        }
        return user;
    }

    private User findByLogin(String login) {
        logger.info("Method findByLogin was called. Params: login={}", login);
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        return user;
    }
}
