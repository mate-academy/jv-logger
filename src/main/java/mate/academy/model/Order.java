package mate.academy.model;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Order {
    private static final Logger logger = LogManager.getLogger(Product.class);
    private Long orderId;
    private List<Product> products;
    private Long userId; // the identifier of user who complete the order

    public Order() {
    }

    public Order(List<Product> products, Long userId) {
        this.products = products;
        this.userId = userId;
    }

    public Long getOrderId() {
        logger.info("Getter for orderID returned: " + orderId);
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        logger.info("Getter for products returned: " + products);
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getUserId() {
        logger.info("Getter for userID returned: " + userId);
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
