package demo.service.order;

import demo.domain.Order;
import demo.domain.OrderCreateForm;
import demo.domain.SortType;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderService {
    /**
     * Create new order
     * @param form
     * @return sorted list
     */
    @Transactional
    String processOrder(OrderCreateForm form);

    /**
     * Get list of all orders
     * @return list of all orders
     */
    Iterable<Order> findAll();

    /**
     * Get Order by User Id
     * @param id
     * @return Order
     */
    Iterable<Order> getOrdersByUserId(long id);
}
