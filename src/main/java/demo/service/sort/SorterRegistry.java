package demo.service.sort;

import demo.domain.SortTypeKey;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Polina on 22.03.2015.
 */
@Component
public class SorterRegistry {
    Map<SortTypeKey, ArraySorter> registry = new HashMap<>();

    public ArraySorter getSorter(SortTypeKey key) {
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
                default:
                    throw new IllegalArgumentException("Illegal sort key: " + key);
            }
        }

        return registry.get(key);
    }
}
