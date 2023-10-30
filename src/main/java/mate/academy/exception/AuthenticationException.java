/**
 * Provides exception classes for the application.
 */
package mate.academy.exception;

public class AuthenticationException extends Exception {
    /**
     * Constructs a new AuthenticationException
     * with the specified detail message.
     *
     * @param message the detail message.
     */
    public AuthenticationException(final String message) {
        super(message);
    }
}
