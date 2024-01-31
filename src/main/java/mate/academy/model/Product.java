package mate.academy.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;

public class Product {
    private static final Logger logger = LogManager.getLogger(Product.class);
    private String title;
    private BigDecimal price;

    public Product() {
        logger.trace("Product constructor called");
    }

    public Product(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
        logger.trace("Product constructor called with title: {} and price: {}", title, price);
    }

    public String getTitle() {
        logger.trace("getTitle method called");
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        logger.trace("setTitle method called with title: {}", title);
    }

    public BigDecimal getPrice() {
        logger.trace("getPrice method called");
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        logger.trace("setPrice method called with price: {}", price);
    }
}
