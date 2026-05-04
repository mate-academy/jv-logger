package mate.academy.service;

import mate.academy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = 
            LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) {
        logger.trace("Enter login method: login={}", login);
        if (login == null || password == null) {
            logger.error("Login or password is null");
            throw new IllegalArgumentException("Login/password is null");
        }
        logger.debug("Checking credentials for user={}", login);
        if ("admin".equals(login) && "1234".equals(password)) {
            logger.info("User logged in successfully: {}", login);
            return new User(login, password);
        }
        logger.warn("Login failed for user={}", login);
        throw new RuntimeException("Invalid credentials");
    }
}

