package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chatmessages")
public class ChatMessageController {
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @GetMapping("/")
    public List<ChatMessage> getAllMessages(){
        return chatMessageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ChatMessage> getMessageById(@PathVariable long id){
        return chatMessageRepository.findById(id);
    }

    @GetMapping("/{roomId}")
    public List<ChatMessage> getAllMessagesForRoom(@PathVariable long roomId){
        return chatMessageRepository.findAllByRoom(chatRoomRepository.findById(roomId).get());
    }

    @PostMapping(value = "/")
    public ChatMessage postNewMessage(@RequestBody ChatMessage chatMessage){
        return chatMessageRepository.save(chatMessage);
    }
}
