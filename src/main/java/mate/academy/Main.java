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
        Logger logger = LogManager.getLogger(Main.class);
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user = new User("Bob", "1234");
        try {
            user = authenticationService.login(user.getLogin(), user.getPassword());
        } catch (AuthenticationException e) {
            logger.error("Authentication failed for login: " + user.getLogin());
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
