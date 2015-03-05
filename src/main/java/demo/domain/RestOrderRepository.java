package demo.domain;

//experiment
/**
 * Created by Polina on 04.03.15.
 */

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface RestOrderRepository extends PagingAndSortingRepository<Order, Long> {
}
