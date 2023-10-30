/**
 * Contains service interfaces and implementations.
 */
package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;

/**
 * The service interface for user authentication.
 */
public interface AuthenticationService {
    /**
     * Logs in a user with the specified login and password.
     *
     * @param login    the login of the user
     * @param password the password of the user
     * @return the authenticated user
     * @throws AuthenticationException if the login or password is incorrect
     */
    User login(String login, String password) throws AuthenticationException;
}
