package demo.service.order;

import demo.domain.*;
import demo.repository.OrderRepository;
import demo.service.sortType.SortTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SortTypeService sortTypeService;

    @Override
    public String processOrder(OrderCreateForm form) {
        if (form == null) {
            throw new IllegalArgumentException("Argument is null: form = " + form);
        }

//        (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
//        UserDetails currentUser = (UserDetails) authentication.getPrincipal();

        SortType sortType = sortTypeService.findOne(form.getSortType());
        if (sortType == null) {
            throw new NoSuchElementException("Sort Type not found! OrderCreateForm: " + form);
        }

        String[] split = form.getList().split(",");
        List<String> list = Arrays.asList(split);

        ArraySorter arraySorter = ArraySorterRegistry.get(sortType.getKey());
        List<String> sorted = arraySorter.sort(list);

        String result = StringUtils.arrayToCommaDelimitedString(sorted.toArray());

        Order order = new Order();
        order.setList(form.getList());
        order.setResult(result);
        order.setSortType(sortType);
        Order saved = orderRepository.save(order);

        return result;
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }
}

interface ArraySorter {
//    enum Key {
//        BUBBLE_SORT, MERRGE_SORT, LSDRADIX_SORT
//    }

    //supposed to be different in different implementations
    List<String> sort(List<String> original);
}

class BubbleSorter implements ArraySorter {

    @Override
    public List<String> sort(List<String> original) {
        List<String> result = new ArrayList<>(original);
        Collections.sort(result);

        return result;
    }
}

class MergeSorter implements ArraySorter {

    @Override
    public List<String> sort(List<String> original) {
        List<String> result = new ArrayList<>(original);
        Collections.sort(result);

        return result;
    }
}

class LsdRadixSorter implements ArraySorter {

    @Override
    public List<String> sort(List<String> original) {
        List<String> result = new ArrayList<>(original);
        Collections.sort(result);

        return result;
    }
}

class ArraySorterRegistry {
    static Map<SortTypeKey, ArraySorter> registry = new HashMap<>();

    static ArraySorter get(SortTypeKey key) {
//        SortTypeKey arraySorterKey = SortTypeKey.valueOf(key);
        if (!registry.containsKey(key)) {
            switch (key) {
                case BUBBLE_SORT:
                    registry.put(key, new BubbleSorter());
                    break;
                case MERGE_SORT:
                    registry.put(key, new MergeSorter());
                    break;
                case LSDRADIX_SORT:
                    registry.put(key, new LsdRadixSorter());
                    break;
            }
        }

        return registry.get(key);
    }
}