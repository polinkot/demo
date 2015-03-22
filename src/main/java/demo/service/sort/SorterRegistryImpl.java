package demo.service.sort;

import demo.domain.SortTypeKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Polina on 22.03.2015.
 */
public class SorterRegistryImpl implements SorterRegistry {
    Map<SortTypeKey, ArraySorter> registry = new HashMap<>();

    @Override
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

@Configuration
class SorterRegistryConfig {
    @Bean
    public SorterRegistry getSorterRegistry() {
        return new SorterRegistryImpl();
    }
}

