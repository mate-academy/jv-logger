package mate.academy;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.AuthenticationServiceImpl;
import mate.academy.service.OrderService;
import mate.academy.service.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user;
        try {
            logger.info("Attempting to log in user.");
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            logger.error("Authentication failed: " + e.getMessage(), e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        logger.info("Attempting to complete order for user with ID: " + user.getUserId());
        orderService.completeOrder(user.getUserId());
    }
}
