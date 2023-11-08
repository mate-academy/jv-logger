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
    private static final String LOGGER_DEBUG_MESSAGE = "Authentication error has occurred "
                                                        + "while authentication with login=";
    private static final Logger logger = LogManager.getLogger("mate.academy");

    public static void main(String[] args) {

        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user;
        try {
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            logger.debug(LOGGER_DEBUG_MESSAGE);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
