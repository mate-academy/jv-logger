package mate.academy;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.AuthenticationServiceImpl;
import mate.academy.service.OrderService;
import mate.academy.service.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user;
        try {
            user = authenticationService.login("bob", "1234");
            // Log successful authentication
            logger.info("User {} has been successfully authenticated", user.getLogin());
        } catch (AuthenticationException e) {
            // Log authentication failure
            logger.error("Authentication failed: {}", e.getMessage());
            return;
        }

        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());

        // Log completion of the order
        logger.info("Order successfully completed for user with ID: {}", user.getUserId());
    }
}
