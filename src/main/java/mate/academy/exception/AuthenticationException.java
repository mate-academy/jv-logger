package mate.academy.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationException extends Exception {
    private static final Logger logger = LogManager.getLogger(AuthenticationException.class);

    public AuthenticationException(String message) {
        super(message);
        logger.error(message);
    }
}
