package mate.academy;

import java.util.Optional;
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
        } catch (AuthenticationException e) {
            Optional<User> optional = Optional.ofNullable(user);
            logger.error("Cannot login. Params: user - {}", optional.map(value -> "login: "
                    + value.getLogin() + ", userId - "
                    + value.getUserId()).orElse("is null"), e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
