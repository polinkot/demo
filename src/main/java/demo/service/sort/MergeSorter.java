package demo.service.sort;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Polina on 22.03.2015.
 */
@Component
@Lazy
class MergeSorter implements ArraySorter {
    @Override
    public List<String> sort(List<String> original) {
        List<String> result = new ArrayList<>(original);
        Collections.sort(result, Collections.reverseOrder());

        return result;
    }
}
