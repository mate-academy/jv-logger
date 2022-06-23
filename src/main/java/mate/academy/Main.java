package mate.academy;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.AuthenticationServiceImpl;
import mate.academy.service.OrderService;
import mate.academy.service.OrderServiceImpl;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.trace("Main jv-logger started");
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user;
        try {
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            logger.error("Login failed", e);
            return;
        }
        logger.info("Login of user={} was successful", user.getLogin());
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
        logger.trace("Main jv-logger stopped");
    }
}
