package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(1L);
        logger.info("Order was completed from accountId= {} Order number: {} " + "\n{}",
                userId, order.getOrderId(), order.getProducts()
                        .stream()
                        .map(n -> (n.getTitle() + ", price " + n.getPrice()))
                        .collect(Collectors.joining("\n")));
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        logger.info("Products: {} added to shopping cart to userId= {}", products
                .stream()
                        .map(n -> String.valueOf(n.getTitle()))
                        .collect(Collectors.joining(", ")), userId);
        return products;
    }
}
