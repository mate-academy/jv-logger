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
        String username = "bob";
        String password = "1234";
        try {
            logger.debug("Method login was called. Params: username={}, "
                    + "password={}", username, password);
            user = authenticationService.login(username, password);
            logger.info("User {} logged in successfully", user.getLogin());
        } catch (AuthenticationException e) {
            logger.error("Can't login. Params: username={}, password={}", username, password, e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
