package de.htw.berlin.MensaTalk.MensaTalkBackend.RestApi.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.ProfileUserDTO;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    private String[] defaultUsers =
            {"{\"id\":1,\"username\":\"dummyUser\",\"age\":26,\"interests\":\"Sports, Coding, Food\",\"status\":\"Whats up ppl??\"}",
                    "{\"id\":999,\"username\":\"abteilung6\",\"age\":26,\"interests\":\"Sports, Coding, Food\",\"status\":\"Whats up ppl??\"}"};

    @Test
    @Order(1)
    public void getAllUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(defaultUsers[0])))
                .andExpect(content().string(containsString(defaultUsers[1])));
    }

    @Test
    @Order(2)
    public void getOneUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(defaultUsers[0])));

    }

    @Test
    @Order(3)
    public void postOneUsers() throws Exception {
        ProfileUserDTO testUser = new ProfileUserDTO();
        testUser.setAge(22);
        testUser.setId(1l);
        testUser.setInterests("fancy Stuff");
        testUser.setStatus("ill fade away soon..");


        mvc.perform(MockMvcRequestBuilders.put("/users").content(asJsonString(testUser))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
