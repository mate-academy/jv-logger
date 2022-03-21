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
        User invalidUser;
        OrderService orderService = new OrderServiceImpl();
        try {
            user = authenticationService.login("bob", "1234");
            orderService.completeOrder(user.getUserId());
            invalidUser = authenticationService.login("bob", "qwerty");
            orderService.completeOrder(invalidUser.getUserId());
        } catch (AuthenticationException e) {
            logger.error("Can't login user", e);
        }
    }
}
