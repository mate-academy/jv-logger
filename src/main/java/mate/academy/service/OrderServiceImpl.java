package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    public static final Logger LOGGER = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        LOGGER.debug("CompleteOrder method was called. User id: {}", userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(1L);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        LOGGER.info("Data from DB successfuly fetched, userId: {}", userId);
        return products;
    }
}

