package mate.academy.model;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Order {
    private static final Logger logger = LogManager.getLogger(Order.class);
    private Long orderId;
    private List<Product> products;
    private Long userId; // the identifier of user who complete the order

    public Order() {
        logger.trace("Order constructor called");
    }

    public Order(List<Product> products, Long userId) {
        this.products = products;
        this.userId = userId;
        logger.trace("Order constructor called with products: {} and userId: {}", products, userId);
    }

    public Long getOrderId() {
        logger.trace("getOrderId method called");
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
        logger.trace("setOrderId method called with orderId: {}", orderId);
    }

    public List<Product> getProducts() {
        logger.trace("getProducts method called");
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        logger.trace("setProducts method called with products: {}", products);
    }

    public Long getUserId() {
        logger.trace("getUserId method called");
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
        logger.trace("setUserId method called with userId: {}", userId);
    }
}
