package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The implementation of the AuthenticationService interface.
 */
public class AuthenticationServiceImpl implements AuthenticationService {
    /**
     * The logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(
            AuthenticationServiceImpl.class.getName());

    /**
     * Logs in a user with the specified login and password.
     *
     * @param login    the login of the user
     * @param password the password of the user
     * @return the authenticated user
     * @throws AuthenticationException if the login or password is incorrect
     */
    @Override
    public User login(final String login, final String password)
            throws AuthenticationException {
        LOGGER.info("Method login was called with login: " + login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            String errorMessage = "Username or password are incorrect";
            LOGGER.log(Level.SEVERE, errorMessage);
            throw new AuthenticationException(errorMessage);
        }
        return user;
    }

    /**
     * Finds a user by the specified login.
     *
     * @param login the login of the user
     * @return the user with the specified login
     */
    private User findByLogin(final String login) {
        LOGGER.info("findByLogin method called with login: "
                + login);
        User user = new User(login, "1234");
        // this user identifier should be set by DB.
        // We will use dummy data for this example
        user.setUserId(2L);
        return user;
    }
}
