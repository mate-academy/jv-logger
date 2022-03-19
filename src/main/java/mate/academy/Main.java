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
    private static final int USER_LOGIN_NUMBER = 3;

    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        logger.info("AuthenticationService object was created");
        User user = null;
        OrderService orderService = new OrderServiceImpl();
        logger.info("OrderService object was created");
        for (int i = 0; i < USER_LOGIN_NUMBER; i++) {
            try {
                switch (i) {
                    case 0:
                        user = authenticationService.login("bob", "1234");
                        break;
                    case 1:
                        user = authenticationService.login("jake", "1234");
                        break;
                    case 2:
                        user = authenticationService.login("bob", "qwerty");
                        break;
                    default:
                        break;
                }
            } catch (AuthenticationException e) {
                logger.error("Can't login user", e);
                return;
            }
            orderService.completeOrder(user.getUserId());
        }
    }
}
