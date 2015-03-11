package demo.web;

import demo.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class OrderControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/order/list").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testProcessOrder() throws Exception {
        mvc.perform(
                post("/order/process", "json")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"list\" : \"llllllllll,ppppppp,ffffff\", \"sortType\" : 1, \"userId\" : 1}".getBytes()))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"list\":\"llllllllll,ppppppp,ffffff\",\"result\":\"ffffff,llllllllll,ppppppp\",\"sortType\":1,\"userId\":1}"))
                .andDo(print());
    }
}

/*
import java.net.URL;

import demo.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class OrderControllerTest {

    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/order/list");
        template = new TestRestTemplate();
    }

    @Test
    public void test() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertThat(response.getStatusCode().value(), equalTo(200));
        assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
    }
}
*/

/*
*/
/*
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class OrderControllerTest {
    RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testRequest() throws Exception {
//        HttpHeaders headers = template.getForEntity("http://localhost:8080/generateOrder", Order.class).getHeaders();
//        System.out.println("***************" + template);
//        MatcherAssert.assertThat(headers.getLocation().toString(), containsString("host"));

//        Order order = new Order();
//        HttpEntity<Order> entity = new HttpEntity<Order>(order);
//        ResponseEntity<Order> response = restTemplate.postForEntity("http://localhost:8080/addOrder", entity, Order.class);
//        Order e = response.getBody();

        Random r = new Random();

        char[] chars = new char[6];
        char c = (char) (r.nextInt(26) + 'a');
        Arrays.fill(chars, c);
        String s1 = new String(chars);

        c = (char) (r.nextInt(26) + 'a');
        Arrays.fill(chars, c);
        String s2 = new String(chars);

        c = (char) (r.nextInt(26) + 'a');
        Arrays.fill(chars, c);
        String s3 = new String(chars);

        String[] methods = {"BUBBLE_SORT", "MERRGE_SORT", "LSDRADIX_SORT"};
        int sortMethodId = new Random().nextInt(3);

        int sortTypeId = new Random().nextInt(3) + 1;


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"sortType\":\"BUBBLE_SORT_TEST\",\"list\":[\"" + s1 + "\",\"" + s2 + "\",\"" + s3 + "\"]}", headers);
//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"sortType\":{\"sortTypeId\":2},\"list\":[\"" + s1 + "\",\"" + s2 + "\",\"" + s3 + "\"]}", headers);
//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"orderId\":38,\"sortType\":{\"sortTypeId\":2,\"name\":\"Merge sort\",\"cost\":0.5159491546571577},\"list\":[\"ffffff\",\"nnnnnn\",\"qqqqqq\"]}", headers);
//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"list\":[\"" + s1 + "\",\"" + s2 + "\",\"" + s3 + "\"]}", headers);
//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"list\":[\"" + s1 + "\",\"" + s2 + "\",\"" + s3 + "\"],\"sortMethod\":\"" + methods[sortMethodId] + "\"}", headers);
        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"list\":[\"" + s1 + "\",\"" + s2 + "\",\"" + s3 + "\"]}", headers);
//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"list\":[\"" + s1 + "\",\"" + s2 + "\",\"" + s3 + "\"]}", headers);
//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"list\":[\"bbbbbb\",\"pppppp\",\"hhhhhh\"]}}", headers);
//        ResponseEntity<ArrayList> response = restTemplate.postForEntity("http://localhost:8080/processOrder/" + sortTypeId, entityJSON, ArrayList.class);
        ResponseEntity<ArrayList> response = restTemplate.postForEntity("http://localhost:8080/processOrder/" + sortTypeId, entityJSON, ArrayList.class);
        ArrayList e = response.getBody();

//        $ curl http://blog.lo/blog/posts -d '{"title":"Hello World!","body":"This is my first post!"}' -H 'Content-Type: application/json'
//        {"id":"1","title":"Hello World!","body":"This is my first post!"}


//creation
//curl -i -X POST -H "Content-Type:application/json" -d "{\"sortType\" : \"TEST_LSDRADIX_SORT\"}" http://localhost:8080/orders
//curl -i -X POST -H "Content-Type:application/json" -d "{\"list\" : [\"bbbbbb\",\"ccccccc\",\"aaaaaaaaaaaaaaa\"]}}" http://localhost:8080/processOrder/2

//curl -i -X POST -H "Content-Type:application/json" -d "{\"list\" : \"bbbbbb,aaaaa,ffffff\", \"sortType\" : 1, \"userId\" : 1, \"_csrf\" : \"139a9818-1c62-4a00-a2ef-3b4b2f658f02\"}" http://localhost:8080/processOrder
//curl -i -X GET  http://localhost:8080/viewOrder/6

        //    curl -i -X POST -H "Content-Type:application/json" -d "{\"list\" : \"bbbbbb,aaaaa,ffffff\", \"sortType\" : 1, \"userId\" : 1, \"_csrf\" : \"139a9818-1c62-4a00-a2ef-3b4b2f658f02\"}" http://localhost:8080/order/processJSON
//    curl -i -X POST -H "Content-Type:application/json" -d "{\"list\" : \"bbbbbb,aaaaa,ffffff\", \"sortType\" : 1, \"userId\" : 1}" http://localhost:8080/order/processJSON
//curl -i -X GET  http://localhost:8080/viewOrders
        //curl -i -X GET  http://localhost:8080/viewOrder/6


    }
}
*/