package demo.web;

import demo.domain.SortType;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class SortTypeControllerTest {
    RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testRequest() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entityJSON = new HttpEntity<String>("{\"name\":\"Bubble sort\"}", headers);
        ResponseEntity<SortType> response = restTemplate.postForEntity("http://localhost:8080/addSortType", entityJSON, SortType.class);
        SortType e = response.getBody();

        entityJSON = new HttpEntity<String>("{\"name\":\"Merge sort\"}", headers);
        response = restTemplate.postForEntity("http://localhost:8080/addSortType", entityJSON, SortType.class);

        entityJSON = new HttpEntity<String>("{\"name\":\"LSDRadixSort\"}", headers);
        response = restTemplate.postForEntity("http://localhost:8080/addSortType", entityJSON, SortType.class);
    }
}
