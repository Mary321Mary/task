package spring.test;

import java.io.IOException;
import java.nio.charset.Charset;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import spring.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public class RestServiceApplicationTest {

    @Autowired
    MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@MockBean
	private UserService userService;

    private final MediaType      contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Test
    public void testFindAllUsers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
        .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testFindAllCars() throws Exception {
    	String json = this.json(userService.findAll());
        this.mockMvc.perform(MockMvcRequestBuilders.post("/car/all").contentType(this.contentType)
        .content(json))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
        .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testFindCarById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/car/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.equalTo(1)))
                .andDo(MockMvcResultHandlers.print());
    }

    protected String json(final Object o) throws IOException {
        final MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
