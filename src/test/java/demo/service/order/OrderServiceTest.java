package demo.service.order;

import demo.DemoApplication;
import demo.domain.Order;
import demo.domain.OrderCreateForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void testProcessOrder() {
        OrderCreateForm form = new OrderCreateForm();
        form.setList("www,ddd,mmm");
        form.setSortType(2);
        form.setUserId(1);
        String sorted = orderService.processOrder(form);
        assertEquals("ddd,mmm,www", sorted);
    }

    @Test
    public void testGetOrdersByUserId() {
        Iterable<Order> orders = orderService.getOrdersByUserId(1L);
        assertNotNull("Order list is null.", orders);
    }

    @Test
    public void findAllOrders() {
        Iterable<Order> all = this.orderService.findAll();
        assertNotNull("Order list is null.", all);
    }
}
