package mate.academy.exception;

public class AuthenticationException extends Exception {

    public AuthenticationException(String message) {
        throw new RuntimeException(message);
    }
}
