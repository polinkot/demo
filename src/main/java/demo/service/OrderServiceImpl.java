package demo.service;

import demo.domain.Order;
import demo.domain.OrderRepository;
import demo.domain.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<String> processOrder(Order order, SortType sortType) {
        if (order == null || sortType == null) {
            throw new IllegalArgumentException("Argument is null: order = " + order + " sortType = " + sortType);
        }

        order.setSortType(sortType);
        Order saved = orderRepository.save(order);

        ArraySorter arraySorter = ArraySorterRegistry.get(saved.getSortType().getKey());
        List<String> result = arraySorter.sort(saved.getList());

        return result;
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }
}

interface ArraySorter {
    enum Key {BUBBLE_SORT, MERRGE_SORT, LSDRADIX_SORT}

    //supposed to be diiferent in different implementations
    List<String> sort(List<String> original);
}

class BubbleSorter implements ArraySorter {

    @Override
    public List<String> sort(List<String> original) {
        List<String> result = new ArrayList<String>(original);
        Collections.sort(result);

        return result;
    }
}

class MergeSorter implements ArraySorter {

    @Override
    public List<String> sort(List<String> original) {
        List<String> result = new ArrayList<String>(original);
        Collections.sort(result);

        return result;
    }
}

class LsdRadixSorter implements ArraySorter {

    @Override
    public List<String> sort(List<String> original) {
        List<String> result = new ArrayList<String>(original);
        Collections.sort(result);

        return result;
    }
}

class ArraySorterRegistry {
    static Map<ArraySorter.Key, ArraySorter> registry = new HashMap<ArraySorter.Key, ArraySorter>();

    static ArraySorter get(String key) {
        ArraySorter.Key arraySorterKey = ArraySorter.Key.valueOf(key);
        if (!registry.containsKey(arraySorterKey)) {
            switch (arraySorterKey) {
                case BUBBLE_SORT:
                    registry.put(arraySorterKey, new BubbleSorter());
                    break;
                case MERRGE_SORT:
                    registry.put(arraySorterKey, new MergeSorter());
                    break;
                case LSDRADIX_SORT:
                    registry.put(arraySorterKey, new LsdRadixSorter());
                    break;
            }
        }

        return registry.get(arraySorterKey);
    }
}