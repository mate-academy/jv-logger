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
        logger.debug("Object AuthenticationServiceImpl was created correct = {}",
                authenticationService);
        try {
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            logger.error("Can not authentication user. Incorrect login or password.");
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        logger.debug("Object OrderServiceImpl was created correct = {}",orderService);
        orderService.completeOrder(user.getUserId());
    }
}
