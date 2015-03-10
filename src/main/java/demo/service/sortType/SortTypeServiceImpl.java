package demo.service.sortType;

import demo.domain.*;
import demo.repository.SortTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SortTypeServiceImpl implements SortTypeService {

    @Autowired
    private SortTypeRepository sortTypeRepository;

    @Override
    public SortType findOne(long id) {
        return sortTypeRepository.findOne(id);
    }
}
