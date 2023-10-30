package mate.academy.model;

import java.math.BigDecimal;

public final class Product {
    /**
     * The title of the product.
     */
    private String title;

    /**
     * The price of the product.
     */
    private BigDecimal price;

    /**
     * Constructs a new Product with the specified title and price.
     *
     * @param titleParam the title of the product
     * @param priceParam the price of the product
     */
    public Product(final String titleParam, final BigDecimal priceParam) {
        this.title = titleParam;
        this.price = priceParam;
    }

    /**
     * Returns the title of the product.
     *
     * @return the title of the product
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the product.
     *
     * @param titleParam the title of the product
     */
    public void setTitle(final String titleParam) {
        this.title = titleParam;
    }

    /**
     * Returns the price of the product.
     *
     * @return the price of the product
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param priceParam the price of the product
     */
    public void setPrice(final BigDecimal priceParam) {
        this.price = priceParam;
    }
}
