package demo.repository;

import demo.domain.SortType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortTypeRepository extends JpaRepository<SortType, Long> {
}

