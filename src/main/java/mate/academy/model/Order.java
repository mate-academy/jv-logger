/**
 * Provides model classes for the application.
 */
package mate.academy.model;

import java.util.List;

public final class Order {
    /**
     * The ID of the order.
     */
    private Long orderId;

    /**
     * The list of products in the order.
     */
    private List<Product> products;

    /**
     * The ID of the user who placed the order.
     */
    private Long userId;

    /**
     * Constructs a new Order with the specified
     * list of products and user ID.
     *
     * @param productsParam the list of products in the order
     * @param userIdParam   the ID of the user who placed the order
     */
    public Order(final List<Product> productsParam,
                 final Long userIdParam) {
        this.products = productsParam;
        this.userId = userIdParam;
    }

    /**
     * Returns the ID of the order.
     *
     * @return the ID of the order
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Sets the ID of the order.
     *
     * @param orderIdParam the ID of the order
     */
    public void setOrderId(final Long orderIdParam) {
        this.orderId = orderIdParam;
    }

    /**
     * Returns the list of products in the order.
     *
     * @return the list of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets the list of products in the order.
     *
     * @param productsParam the list of products
     */
    public void setProducts(final List<Product> productsParam) {
        this.products = productsParam;
    }

    /**
     * Returns the ID of the user who placed the order.
     *
     * @return the ID of the user
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who placed the order.
     *
     * @param userIdParam the ID of the user
     */
    public void setUserId(final Long userIdParam) {
        this.userId = userIdParam;
    }
}
