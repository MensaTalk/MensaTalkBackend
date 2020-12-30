package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ChatRoomController {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @RequestMapping("/chatrooms")
    public List<ChatRoom> getRooms(){
        return chatRoomRepository.findAll();
    }

    @RequestMapping(value = "/chatrooms", method = RequestMethod.POST)
    public ChatRoom createRooms(@RequestBody ChatRoomDTO chatRoomDTO){
        ChatRoom newRoom = new ChatRoom(chatRoomDTO.name, new ArrayList<>());
        return chatRoomRepository.save(newRoom);
    }
    @RequestMapping("/chatrooms/{id}")
    public Optional<ChatRoom> getRoomById(@PathVariable long id){
        return chatRoomRepository.findById(id);
    }
}
