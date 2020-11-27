package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ChatRoom")
public class ChatRoomController {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from ChatRoomController!";
    }

    @RequestMapping("/all")
    public List<ChatRoom> getAll() {
        return this.chatRoomRepository.findAll();
    }
}
