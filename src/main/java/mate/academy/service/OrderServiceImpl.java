package mate.academy.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        logger.info("Method completeOrder was called. UserID = {}", userId);
        List<Object> orderData = getAllProductsFromShoppingCart(userId);
        Order order = new Order((List<Product>) orderData.get(0), userId);
        order.setOrderId(1L);
        logger.info("Method completeOrder. Order completed successfully. "
                        + "OrderID = {}, Products Ordered = {}, Price Paid = {}",
                        order.getOrderId(), orderData.get(1), orderData.get(2));
        return order;
    }

    private List<Object> getAllProductsFromShoppingCart(Long userId) {
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        int amountOfProducts = products.size();
        BigDecimal totalPrice = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        logger.info("Successfully received data from the database. "
                        + "UserID = {}, Products In Cart = {}, Total Value = {}",
                        userId, amountOfProducts, totalPrice);
        List<Object> orderData = new ArrayList<>();
        orderData.add(products);
        orderData.add(amountOfProducts);
        orderData.add(totalPrice);
        return orderData;
    }
}
