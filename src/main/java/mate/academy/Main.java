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
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Entering application.");
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user = null;
        try {
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            logger.error("Authentication is bed, user {} and exception = {}", user, e);
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
        logger.info("Exiting application.");
    }
}
