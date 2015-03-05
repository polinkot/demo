package demo.web;

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

        long sortTypeId = new Random().nextInt(3) + 1;


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"sortType\":\"BUBBLE_SORT_TEST\",\"list\":[\"" + s1 + "\",\"" + s2 + "\",\"" + s3 + "\"]}", headers);
//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"sortType\":{\"sortTypeId\":2},\"list\":[\"" + s1 + "\",\"" + s2 + "\",\"" + s3 + "\"]}", headers);
        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"list\":[\"" + s1 + "\",\"" + s2 + "\",\"" + s3 + "\"]}", headers);
//        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"list\":[\"bbbbbb\",\"pppppp\",\"hhhhhh\"]}}", headers);
        ResponseEntity<ArrayList> response = restTemplate.postForEntity("http://localhost:8080/processOrder/" + sortTypeId, entityJSON, ArrayList.class);
        ArrayList e = response.getBody();

//        $ curl http://blog.lo/blog/posts -d '{"title":"Hello World!","body":"This is my first post!"}' -H 'Content-Type: application/json'
//        {"id":"1","title":"Hello World!","body":"This is my first post!"}


//creation
//curl -i -X POST -H "Content-Type:application/json" -d "{\"sortType\" : \"TEST_LSDRADIX_SORT\"}" http://localhost:8080/orders
//curl -i -X POST -H "Content-Type:application/json" -d "{\"list\" : [\"bbbbbb\",\"pppppp\",\"hhhhhh\"]}}" http://localhost:8080/addOrder/2

    }
}
