package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;
import mate.academy.model.Order;
import mate.academy.model.Product;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = Logger.getLogger(OrderServiceImpl.class.getName());

    @Override
    public Order completeOrder(Long userId) {
        logger.info("completeOrder() method was called for userId: " + userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(1L);
        logger.info("Order was successfully created for userId: "
                + userId + " with orderId: " + order.getOrderId());
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        logger.fine("Fetched " + products.size()
                + " products from shopping cart for userId: " + userId);
        return products;
    }
}
