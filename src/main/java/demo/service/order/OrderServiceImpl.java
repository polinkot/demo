package demo.service.order;

import demo.domain.Order;
import demo.domain.OrderCreateForm;
import demo.domain.SortType;
import demo.domain.User;
import demo.repository.OrderRepository;
import demo.service.sort.ArraySorter;
import demo.service.sort.SorterRegistry;
import demo.service.sortType.SortTypeService;
import demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SortTypeService sortTypeService;

    @Autowired
    private UserService userService;

    @Autowired
    private SorterRegistry sorterRegistry;

    @Override
    public String processOrder(OrderCreateForm form) {
        if (form == null) {
            throw new IllegalArgumentException("Argument is null: form = " + form);
        }

        SortType sortType = sortTypeService.findOne(form.getSortType());
        if (sortType == null) {
            throw new NoSuchElementException("Sort Type not found! OrderCreateForm: " + form);
        }

        User user = userService.getUserById(form.getUserId()).orElseThrow(() -> new NoSuchElementException("User not found! OrderCreateForm: " + form));

        String[] split = form.getList().split(",");
        List<String> list = Arrays.asList(split);

        ArraySorter arraySorter = sorterRegistry.getSorter(sortType.getKey());
        List<String> sorted = arraySorter.sort(list);

        String result = StringUtils.arrayToCommaDelimitedString(sorted.toArray());

        Order order = new Order();
        order.setList(form.getList());
        order.setResult(result);
        order.setSortType(sortType);
        order.setUser(user);
        Order saved = orderRepository.save(order);

        return result;
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Iterable<Order> getOrdersByUserId(long id) {
        return orderRepository.findAllByUserId(id);
    }
}
