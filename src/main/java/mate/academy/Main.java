/**
 * Contains the main class of the application.
 */
package mate.academy;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.AuthenticationServiceImpl;
import mate.academy.service.OrderService;
import mate.academy.service.OrderServiceImpl;

import java.util.logging.Logger;

public final class Main {
    /**
     * The logger for the Main class.
     */
    private static final Logger LOGGER = Logger.getLogger(
            Main.class.getName());

    private Main() {
        // private constructor to prevent instantiation
    }

    /**
     * The main method that starts the application.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        AuthenticationService authenticationService =
                new AuthenticationServiceImpl();
        User user;
        try {
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            LOGGER.severe("An authentication exception occurred: "
                    + e.getMessage());
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
