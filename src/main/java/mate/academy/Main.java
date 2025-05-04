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
    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        Logger logger = LogManager.getLogger(Main.class);
        User user;
        try {
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            logger.error("User with login \"{}\" is not able to login.", "bob", e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
