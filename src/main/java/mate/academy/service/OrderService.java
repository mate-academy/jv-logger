package mate.academy.service;

import mate.academy.model.Order;
import org.apache.log4j.Logger;

public interface OrderService {
    Order completeOrder(Long userId);
}
