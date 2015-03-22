package demo.service.sort;

import demo.domain.SortTypeKey;

/**
 * Created by Polina on 22.03.2015.
 */
public interface SorterRegistry {
    ArraySorter getSorter(SortTypeKey key);
}
