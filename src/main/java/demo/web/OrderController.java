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

    @RequestMapping(value = "/order/process", method = RequestMethod.GET)
    public ModelAndView getOrderProcessPage() {
        return new ModelAndView("process_order", "form", new OrderCreateForm());
    }

    @RequestMapping(value = "/order/process", method = RequestMethod.POST)
    public ModelAndView handleOrderCreateForm(@ModelAttribute("form") OrderCreateForm form) {
        String result = orderService.processOrder(form);
        form.setResult(result);
        form.setSaved(true);

        return new ModelAndView("process_order", "form", form);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/viewOrders")
    public Iterable<Order> viewOrders() {
        Iterable<Order> all = orderService.findAll();
        return all;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/orders")
    public ModelAndView getOrderList() {
        Iterable<Order> orderList = orderService.findAll();

        ModelMap model = new ModelMap();
        model.addAttribute("orderList", orderList);

        return new ModelAndView("order_list", model);
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #userId)")
    @RequestMapping("/orders/{userId}")
    public ModelAndView getOrderList(@PathVariable Long userId) {
        Iterable<Order> orderList = orderService.getOrdersByUserId(userId);

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
}
