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
    public static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user = new User("bill", "qwerty");
        try {
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            logger.debug("AuthenticationException was catched with user: login={}",
                    user.getLogin());
            throw new RuntimeException("The user: " + user.getLogin()
                    + "haven't been authenticated", e);
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
