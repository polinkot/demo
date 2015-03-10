package demo.service.sortType;

import demo.domain.SortType;
import demo.domain.User;
import demo.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface SortTypeService {
    /**
     * Find Sort Type
     * @param id
     * @return SortType
     */
    SortType findOne(long id);
}
