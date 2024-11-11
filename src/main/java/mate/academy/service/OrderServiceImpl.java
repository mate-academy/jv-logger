package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = (Logger) LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        logger.info("Method completeOrder was called with userId: {}", userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(1L);
        logger.info("Order created with ID: {} for user ID: {}", order.getOrderId(), userId);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        logger.info("Fetching products from shopping cart for userId: {}", userId);
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        logger.info("Successfully fetched {} products for userId: {}", products.size(), userId);
        return products;
    }
}
