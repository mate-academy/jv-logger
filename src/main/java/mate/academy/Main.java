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
        User user = null;
        try {
            user = authenticationService.login("bob", "1234");
            logger.info("User {} logged in successfully.", getUserLogin(user));
        } catch (AuthenticationException e) {
            logger.error("Login failed for user {} with message: {}",
                    getUserLogin(user), e.getMessage(), e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }

    private static String getUserLogin(User user) {
        // there is no input username, so I return an empty one
        return user != null ? user.getLogin() : "";
    }
}
