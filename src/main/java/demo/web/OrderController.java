package demo.web;

import demo.domain.Order;
import demo.domain.SortType;
import demo.domain.SortTypeRepository;
import demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public String index() {
        return "Array sorting system.";
    }

    @RequestMapping(value = "/processOrder/{sortTypeId}", method = RequestMethod.POST)
    public
    @ResponseBody
    List<String> processOrder(@RequestBody Order order, @PathVariable("sortTypeId") SortType sortType) {
        List<String> sorted = orderService.processOrder(order, sortType);
        return sorted;
    }

    @RequestMapping("/viewOrders")
    public Iterable<Order> viewOrders() {
        Iterable<Order> all = orderService.findAll();
        return all;
    }

    @RequestMapping("/order_list.ftl")
    public ModelAndView getOrderList() {
        Iterable<Order> orderList = orderService.findAll();

        ModelMap model = new ModelMap();
        model.addAttribute("orderList", orderList);

        return new ModelAndView("order_list", model);
    }

    //experiment
    //remove
    @RequestMapping("/viewOrder/{id}")
    public Order viewOrder(@PathVariable("id") Order order) {
        return order;
    }

//    @RequestMapping(value = "/viewOrder")
//    public Order viewOrder() {
//        Order order = orderRepository.findOne(1L);
//        return order;
//    }

    //extract to separate
/*
    @Autowired
    private SortTypeRepository sortTypeRepository;

    @RequestMapping(value = "/addSortType", method = RequestMethod.POST)
    public
    @ResponseBody
    SortType addSortType(@RequestBody SortType sortType) {
        SortType saved = sortTypeRepository.save(sortType);
        return saved;
    }
*/
}
