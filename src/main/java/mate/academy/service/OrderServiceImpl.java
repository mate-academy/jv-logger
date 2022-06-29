package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    private static final int IPHONE_PRICE = 1199;
    private static final int MACBOOK_PRICE = 1399;
    private static final int XIAOMI_12_PRICE = 499;

    @Override
    public Order completeOrder(Long userId) {
        logger.info("Method completeOrder was called. Params: userId={}", userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(1L);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(IPHONE_PRICE));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(MACBOOK_PRICE));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(XIAOMI_12_PRICE));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        logger.info("Data was successfully fetched from DB. Params: userId={}", userId);
        return products;
    }
}
