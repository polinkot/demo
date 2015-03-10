package demo.repository;

import demo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Iterable<Order> findAllByUserId(long id);
}

