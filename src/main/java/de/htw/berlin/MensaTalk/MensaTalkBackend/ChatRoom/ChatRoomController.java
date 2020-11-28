package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chatrooms")
public class ChatRoomController {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @RequestMapping("/")
    public List<ChatRoom> getRooms(){
        return chatRoomRepository.findAll();
    }
    @RequestMapping("/{id}")
    public Optional<ChatRoom> getRoomById(@PathVariable long id){
        return chatRoomRepository.findById(id);
    }
}
