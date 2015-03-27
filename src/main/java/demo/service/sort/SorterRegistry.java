package demo.service.sort;

import demo.domain.SortTypeKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by Polina on 22.03.2015.
 */
@Component
@Lazy
public class SorterRegistry {
    @Autowired
    @Lazy
    private BubbleSorter bubbleSorter;

    @Autowired
    @Lazy
    private MergeSorter mergeSorter;

    @Autowired
    @Lazy
    private LsdRadixSorter lsdRadixSorter;

    public ArraySorter getSorter(SortTypeKey key) {
        switch (key) {
            case BUBBLE_SORT:
                return bubbleSorter;
            case MERGE_SORT:
                return mergeSorter;
            case LSDRADIX_SORT:
                return lsdRadixSorter;
            default:
                throw new IllegalArgumentException("Illegal sort key: " + key);
        }
    }
}
