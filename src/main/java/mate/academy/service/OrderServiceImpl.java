package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        logger.info("The user with userId {} was called completeOrder", userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        // NOTE: In production ready code this order identifier should be generated by DB
        // For test purpose we simplify this and return dummy data
        order.setOrderId(1L);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        // NOTE: In production ready code this method should fetch data from DB
        // For test purpose we simplify this method and return dummy data
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        logger.info("The user with userId {} got successful fetched data from DB", userId);
        return products;
    }
}
