package demo.service;

import demo.domain.Order;
import demo.domain.OrderRepository;
import demo.domain.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public List<String> processOrder(Order order, SortType sortType) {
        if (order == null || sortType == null) {
            throw new IllegalArgumentException("Argument is null: order = " + order + " sortType = " + sortType);
        }

        order.setSortType(sortType);
        Order saved = orderRepository.save(order);

        //extract to class sorter
        ArrayList<String> sortable = new ArrayList<String>(saved.getList());
        Collections.sort(sortable);

        return sortable;
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }
}