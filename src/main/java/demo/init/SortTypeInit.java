package demo.init;

import demo.domain.SortType;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class SortTypeInit {
    public static void main(String[] args) {
        RestTemplate restTemplate = new TestRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<HttpEntity> entities = new ArrayList<HttpEntity>();
        entities.add(new HttpEntity<String>("{\"key\":\"BUBBLE_SORT\", \"name\":\"Bubble sort\"}", headers));
        entities.add(new HttpEntity<String>("{\"key\":\"MERRGE_SORT\", \"name\":\"Merge sort\"}", headers));
        entities.add(new HttpEntity<String>("{\"key\":\"LSDRADIX_SORT\", \"name\":\"LSDRadixSort\"}", headers));

        for (HttpEntity entity : entities) {
            restTemplate.postForEntity("http://localhost:8080/addSortType", entity, SortType.class);
        }
    }
}
