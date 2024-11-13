package mate.academy;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.Order;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.AuthenticationServiceImpl;
import mate.academy.service.OrderService;
import mate.academy.service.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger= LogManager.getLogger(Main.class);
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user;
        try {
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            logger.error("Failed to authenticate user. Reason: {}", e.getMessage(), e);
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.completeOrder(user.getUserId());
        logger.info("Order completed successfully. Order details: {}", order);
    }
}
