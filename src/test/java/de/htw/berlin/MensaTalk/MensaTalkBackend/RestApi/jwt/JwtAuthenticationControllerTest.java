package de.htw.berlin.MensaTalk.MensaTalkBackend.RestApi.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomDTO;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.JwtUserDTO;
import de.htw.berlin.MensaTalk.MensaTalkBackend.jwt.request.JwtRequest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class JwtAuthenticationControllerTest {
    @Autowired
    private MockMvc mvc;

    @ParameterizedTest
    @ValueSource(strings = {"/users","/users/0","/chatrooms/0","/chatmessages","/chatmessages/0","/chatrooms/0/chatmessages}"})
    public void shouldNotAllowAccessToUnauthenticatedUsers(String urls) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(urls)).andExpect(status().isUnauthorized());
    }
    @Test
    public void shouldAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/chatrooms")).andExpect(status().isOk());
    }

    @Test
    @Order(1)
    public void registerUser() throws Exception {
        JwtUserDTO testUserDTO = new JwtUserDTO();
        testUserDTO.setUsername("testUserName");
        testUserDTO.setPassword("testPassword");

        mvc.perform(MockMvcRequestBuilders.post("/register")
                .content(asJsonString(testUserDTO)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    public void authenticateUser() throws Exception {
        JwtRequest testRequest = new JwtRequest();
        testRequest.setUsername("testUserName");
        testRequest.setPassword("testPassword");

        mvc.perform(MockMvcRequestBuilders.post("/authenticate")
                .content(asJsonString(testRequest)).contentType(MediaType.APPLICATION_JSON)
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
