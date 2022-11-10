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
        logger.info("Data successful fetched from DB."
                + " Params: Params: title={}, price={}", title, price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
