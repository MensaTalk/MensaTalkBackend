package de.htw.berlin.MensaTalk.MensaTalkBackend.RestApi.ChatMessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage.ChatMessage;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage.ChatMessageDTO;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage.ChatMessageRepository;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatMessageControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    public ChatMessageRepository chatMessageRepository;

    private String[] defaultMessages =
            {"\"chatRoomId\":1,\"authorName\":\"dummyUser\",\"textMessage\":\"first message room 1\"",
                    ",\"chatRoomId\":1,\"authorName\":\"dummyUser\",\"textMessage\":\"second message room 1\"",
                    ",\"chatRoomId\":1,\"authorName\":\"dummyUser\",\"textMessage\":\"thid message room 1\""};

    @Test
    public void getAllMessages() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/chatmessages"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(defaultMessages[0])))
                .andExpect(content().string(containsString(defaultMessages[1])))
                .andExpect(content().string(containsString(defaultMessages[2])));
    }

    @Test
    public void getOneMessages() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/chatmessages/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(defaultMessages[0])));
    }

    @Test
    public void getMessagesforRoomOneShouldBeEmptyArray() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/chatrooms/0/chatmessages"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    public void postMessage() throws Exception {
        ChatMessageDTO testMessage = new ChatMessageDTO();
        testMessage.setChatRoomId(0l);
        testMessage.setAuthorName("dummyUser");
        testMessage.setTextMessage("testMessage");
        testMessage.setCreated_at(Date.from(Instant.now()));


        mvc.perform(MockMvcRequestBuilders.post("/chatmessages")
                .content("["+asJsonString(testMessage)+"]").contentType(MediaType.APPLICATION_JSON)
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
