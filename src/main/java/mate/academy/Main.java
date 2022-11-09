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
    private static final String NAME_BOB = "bob";
    private static final String VALID_PASSWORD = "1234";

    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user = new User(NAME_BOB, VALID_PASSWORD);
        try {
            user = authenticationService.login(user.getLogin(), user.getPassword());
        } catch (AuthenticationException e) {
            LOGGER.error("login failed for user {} ", user.getLogin(), e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
