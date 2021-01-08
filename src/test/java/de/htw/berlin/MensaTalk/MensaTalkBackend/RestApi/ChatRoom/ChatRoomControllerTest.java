package de.htw.berlin.MensaTalk.MensaTalkBackend.RestApi.ChatRoom;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatRoomControllerTest {
    @Autowired
    private MockMvc mvc;

    private String defaultTableList = "{\"id\":1,\"name\":\"Table 1\"},{\"id\":2,\"name\":\"Cool Kids\"},{\"id\":3,\"name\":\"abteilung6\"},{\"id\":4,\"name\":\"Wer sitzt hier?\"}";

    @Test
    public void getAllRooms() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/chatrooms"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(defaultTableList)));
    }

    @Test
    public void getOneRoom() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/chatrooms/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Table 1\"}"));
    }

    @Test
    public void postOneRoom() throws Exception {
        ChatRoomDTO testRoom = new ChatRoomDTO();
        testRoom.setName("TestName");

        mvc.perform(MockMvcRequestBuilders.post("/chatrooms")
                .content(asJsonString(testRoom)).contentType(MediaType.APPLICATION_JSON)
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
