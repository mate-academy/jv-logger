package mate.academy.service;

import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        logger.info("Method completeOrder was called for userId: " + userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(generateOrderId());
        logger.info("Order created successfully for userId: " + userId);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        logger.info("Fetching all products from shopping cart for userId: " + userId);
        throw new UnsupportedOperationException("Implement database connection to"
                + "retrieve products");
    }

    private Long generateOrderId() {
        throw new UnsupportedOperationException("Implement unique order ID generation logic");
    }
}
