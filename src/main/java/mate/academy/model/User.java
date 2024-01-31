package mate.academy.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User {
    private static final Logger logger = LogManager.getLogger(User.class);
    private Long userId;
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        logger.trace("User constructor called with login: {}", login);
    }

    public Long getUserId() {
        logger.trace("getUserId method called");
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
        logger.trace("setUserId method called with userId: {}", userId);
    }

    public String getLogin() {
        logger.trace("getLogin method called");
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        logger.trace("setLogin method called with login: {}", login);
    }

    public String getPassword() {
        logger.trace("getPassword method called");
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        logger.trace("setPassword method called with password: {}", password);
    }
}
