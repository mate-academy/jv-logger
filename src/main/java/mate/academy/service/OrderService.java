package mate.academy.service;

import mate.academy.model.Order;

/**
 * The service interface for completing orders.
 */
public interface OrderService {
    /**
     * Completes an order for the user with the specified ID.
     *
     * @param userId the ID of the user
     * @return the completed order
     */
    Order completeOrder(Long userId);
}
