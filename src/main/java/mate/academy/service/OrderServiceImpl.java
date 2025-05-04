package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    private final Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    
    @Override
    public Order completeOrder(Long userId) {
        // TODO: add log message about method completeOrder was called
        logger.debug("Method completeOrder was called. Params: userId={}", userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(1L);
        logger.debug("Order completed. Params: orderId={}, userId={}", order.getOrderId(), userId);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        logger.debug("Fetching products from shopping cart for userId={}", userId);
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        // TODO: add log message about successful fetched data from DB
        logger.debug("Products successfully fetched from DB."
                + " Total products fetched: {}", products.size());
        return products;
    }
}
