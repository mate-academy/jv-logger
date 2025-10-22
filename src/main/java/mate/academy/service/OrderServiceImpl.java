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
        logger.info("Method completeOrder() was called for user with ID: {}", userId);

        List<Product> products = getAllProductsFromShoppingCart(userId);
        logger.debug("Retrieved {} products from shopping cart for user ID: {}",
                products.size(), userId);

        Order order = new Order(products, userId);
        order.setOrderId(1L); // Dummy ID for testing purposes

        logger.info("Order created successfully with ID: {}", order.getOrderId());
        logger.debug("Order details: {}", order);

        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        logger.warn(
                "Method getAllProductsFromShoppingCart() is not implemented yet! userId={}",
                userId);
        return List.of();
    }
}
