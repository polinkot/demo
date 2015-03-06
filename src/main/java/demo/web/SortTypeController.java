package demo.web;

import demo.domain.SortType;
import demo.domain.SortTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SortTypeController {
    @Autowired
    private SortTypeRepository sortTypeRepository;

    @RequestMapping(value = "/addSortType", method = RequestMethod.POST)
    public
    @ResponseBody
    SortType addSortType(@RequestBody SortType sortType) {
        SortType saved = sortTypeRepository.save(sortType);
        return saved;
    }
}
