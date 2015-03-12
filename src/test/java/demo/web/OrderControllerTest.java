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