package demo.service;

import demo.domain.Order;
import demo.domain.SortType;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderService {
    @Transactional
    List<String> processOrder(Order order, SortType sortType);

    Iterable<Order> findAll();
}
