package mate.academy.exception;

import mate.academy.service.AuthenticationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationException extends Exception {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    public AuthenticationException(String message) {
        super(message);
    }
}
