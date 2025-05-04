package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    public Order completeOrder(Long userId) {
        logger.info("Completing order for user with ID: {}", userId);

        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);

        logger.info("Successfully fetched {} products from shopping cart for user ID: {}",
                products.size(), userId);
        Order order = new Order();
        order.setOrderId(1L);
        order.setProducts(products);

        logger.info("Order completed with ID: {} for {} products with total value: ${}",
                order.getOrderId(), products.size(),
                products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));

        return order;
    }
}
