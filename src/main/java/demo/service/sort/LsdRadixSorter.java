package demo.service.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Polina on 22.03.2015.
 */
class LsdRadixSorter implements ArraySorter {

    @Override
    public List<String> sort(List<String> original) {
        List<String> result = new ArrayList<>(original);
        Collections.sort(result);

        return result;
    }
}