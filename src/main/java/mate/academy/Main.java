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
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user;
        try {
            user = authenticationService.login("bob", "1234");
            LOGGER.info("'login' method was invoked "
                    + "with next arguments: user login = {}", user.getLogin());
        } catch (AuthenticationException e) {
            LOGGER.error("User authentication failed."
                    + " Incorrect user login or password ", e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
        LOGGER.info("'completeOrder' method was invoked "
                + "with next arguments: userId = {}", user.getUserId());
    }
}
