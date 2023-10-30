/**
 * Contains the main class of the application.
 */
package mate.academy;

import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.AuthenticationServiceImpl;
import mate.academy.service.OrderService;
import mate.academy.service.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Main {
    /**
     * The logger for the Main class.
     */
    private static Logger logger = LoggerFactory.getLogger(
            Main.class);


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
        } catch (Exception e) {
            logger.error("An authentication exception occurred: ", e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
