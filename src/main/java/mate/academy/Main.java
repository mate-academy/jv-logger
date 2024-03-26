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
        OrderService orderService = new OrderServiceImpl();
        User user;
        try {
            user = authenticationService.login("bob", "1254");
            orderService.completeOrder(user.getUserId());
        } catch (AuthenticationException e) {
            logger.error("Username or password are incorrect" + e);
        }
    }
}
