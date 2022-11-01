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
    private static final String AUTHENTICATION_ERROR_MESSAGE = "Authentication error "
            + "for user with login {}";
    private static final String LOGIN = "bob";
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user;
        try {
            user = authenticationService.login(LOGIN, "1234");
        } catch (AuthenticationException e) {
            logger.error(AUTHENTICATION_ERROR_MESSAGE, LOGIN, e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
