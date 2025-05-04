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
        String loginAttempt = "bob";
        try {
            logger.info("Attempting login for user: {}", loginAttempt);
            user = authenticationService.login(loginAttempt, "1234");
            logger.info("Login successful for user ID: {}", user.getUserId());
        } catch (AuthenticationException e) {
            logger.error("Authentication failed for user: {}", loginAttempt, e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
        logger.info("Order process finished for user ID: {}", user.getUserId());
    }
}
