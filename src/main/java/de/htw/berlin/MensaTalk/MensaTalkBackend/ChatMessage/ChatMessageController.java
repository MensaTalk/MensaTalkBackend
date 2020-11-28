package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChatMessageController {
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    // Direkter Zugriff
    @GetMapping("/chatmessages")
    public List<ChatMessage> getAllMessages(){
        return chatMessageRepository.findAll();
    }

    @GetMapping("/chatmessages/{id}")
    public Optional<ChatMessage> getMessageById(@PathVariable long id){
        return chatMessageRepository.findById(id);
    }

    @PostMapping(value = "/chatmessages")
    public ChatMessage postNewMessage(@RequestBody ChatMessage chatMessage){
        return chatMessageRepository.save(chatMessage);
    }

    // In Abhängigkeit zum Raum
    @GetMapping("/chatrooms/{roomId}/chatmessages")
    public List<ChatMessage> getAllMessagesInRoom(@PathVariable long roomId){
        return chatMessageRepository.findByChatRoomId(roomId);
    }
}
