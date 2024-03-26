package mate.academy;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.AuthenticationServiceImpl;
import mate.academy.service.OrderService;
import mate.academy.service.OrderServiceImpl;

public class Main {
    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        User user = new User("bill", "qwerty");
        try {
            user = authenticationService.login("bob", "1234");
        } catch (AuthenticationException e) {
            throw new RuntimeException("The user: " + user.getLogin()
                    + "haven't been authenticated", e);
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.completeOrder(user.getUserId());
    }
}
