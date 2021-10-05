package mate.academy.model;

import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Product {
    private static final Logger logger = LogManager.getLogger(Product.class);
    private String title;
    private BigDecimal price;

    public Product() {
    }

    public Product(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        logger.info("Getter for title returned: " + title);
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        logger.info("Getter for price returned: " + price);
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
