package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ChatRoom")
public class ChatRoomController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from ChatRoomController!";
    }
}
