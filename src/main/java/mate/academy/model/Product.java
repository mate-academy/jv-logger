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

    @Override
    public String toString() {
        logger.info("Product title = {}, price = {} ", title, price);
        return "Product{"
                + "title='" + title + '\''
                + ", price=" + price + '}';
    }
}
