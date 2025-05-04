package mate.academy.service;

import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public User login(String login, String password) {
        logger.info("Login method was called with user: {}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.error("Failed login attempt for user '{}': incorrect password.", login);
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
