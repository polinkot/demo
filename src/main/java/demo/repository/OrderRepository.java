package demo.repository;

import demo.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Iterable<Order> findAllByUserId(long id);
}

