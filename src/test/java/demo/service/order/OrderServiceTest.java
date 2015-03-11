package demo.service.order;

import demo.domain.Order;
import demo.repository.OrderRepository;
import demo.repository.SortTypeRepository;
import demo.repository.UserRepository;
import demo.service.sortType.SortTypeService;
import demo.service.sortType.SortTypeServiceImpl;
import demo.service.user.UserService;
import demo.service.user.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SortTypeService sortTypeService;

    @Autowired
    private SortTypeRepository sortTypeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Configuration
    static class Config {

        // this bean will be injected into the OrderServiceTest class
        @Bean
        public OrderService orderService() {
            return new OrderServiceImpl();
        }

        // this bean will be injected into the OrderServiceTest class
        @Bean
        public OrderRepository orderRepository() {
            return Mockito.mock(OrderRepository.class);
        }

        // this bean will be injected into the OrderServiceTest class
        @Bean
        public SortTypeService sortTypeService() {
            return new SortTypeServiceImpl();
        }

        // this bean will be injected into the OrderServiceTest class
        @Bean
        public SortTypeRepository sortTypeRepository() {
            return Mockito.mock(SortTypeRepository.class);
        }

        // this bean will be injected into the OrderServiceTest class
        @Bean
        public UserRepository userRepository() {
            return Mockito.mock(UserRepository.class);
        }

        // this bean will be injected into the OrderServiceTest class
        @Bean
        public UserService userService() {
            return new UserServiceImpl(Mockito.mock(UserRepository.class));
        }
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFindById() {
        Iterable<Order> orders = orderService.getOrdersByUserId(1L);
        assertNotNull("Order list is null.", orders);
    }

}
