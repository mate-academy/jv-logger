package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        logger.info("completeOrder() called. userId={}", userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(1L);
        logger.info("Order completed successfully. userId={}, orderId={}, productsCount={}",
                userId, order.getOrderId(), products.size());
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        logger.debug("Fetching products from shopping cart. userId={}", userId);
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        logger.debug("Fetched {} products for userId={}", products.size(), userId);
        return products;
    }
}
