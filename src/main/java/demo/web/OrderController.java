package demo.web;

import demo.domain.Order;
import demo.domain.OrderCreateForm;
import demo.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/process", method = RequestMethod.POST)
    public OrderCreateForm processOrder(@RequestBody OrderCreateForm form) {
        String result = orderService.processOrder(form);
        form.setResult(result);

        return form;
    }

    @RequestMapping("/order/list")
    public Iterable<Order> getOrderList() {
        Iterable<Order> all = orderService.findAll();
        return all;
    }

    @RequestMapping("/order/list/{userId}")
    public Iterable<Order> getOrderList(@PathVariable Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId == null");
        }

        Iterable<Order> all = orderService.getOrdersByUserId(userId);
        return all;
    }

    @RequestMapping("/viewOrder/{id}")
    public Order viewOrder(@PathVariable("id") Order order) {
        return order;
    }

    @RequestMapping(value = "/order/new", method = RequestMethod.GET)
    public ModelAndView getOrderProcessPage() {
        return new ModelAndView("process_order", "form", new OrderCreateForm());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/orders")
    public ModelAndView getOrderListPage() {
        ModelMap model = new ModelMap();
        model.addAttribute("userId", "");

        return new ModelAndView("order_list", model);
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #userId)")
    @RequestMapping("/orders/{userId}")
    public ModelAndView getOrderListPage(@PathVariable Long userId) {
        ModelMap model = new ModelMap();
        model.addAttribute("userId", userId);

        return new ModelAndView("order_list", model);
    }
}



