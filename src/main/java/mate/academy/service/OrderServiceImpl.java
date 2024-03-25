package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        LOGGER.debug("completeOrder method was called. Params: userId={}", userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(1L);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        String stringOfAllProducts = getStringOfAllProducts(products);
        LOGGER.info("Data was successfully fetched. Products={}",
                stringOfAllProducts);
        return products;
    }

    private String getStringOfAllProducts(List<Product> productList) {
        return productList.stream()
                .map(Product::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
