package demo.service.sort;

import java.util.List;

/**
 * Created by Polina on 22.03.2015.
 */
public interface ArraySorter {
    //supposed to be different in different implementations
    List<String> sort(List<String> original);
}
