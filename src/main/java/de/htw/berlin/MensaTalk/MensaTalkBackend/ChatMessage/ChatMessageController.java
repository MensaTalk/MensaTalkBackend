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
    @GetMapping("/")
    public List<ChatMessage> getAllMessages(){
        return chatMessageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ChatMessage> getMessageById(@PathVariable long id){
        return chatMessageRepository.findById(id);
    }

    @PostMapping(value = "/")
    public ChatMessage postNewMessage(@RequestBody ChatMessage chatMessage){
        return chatMessageRepository.save(chatMessage);
    }

    // In Abhängigkeit zum Raum
    @GetMapping("chatrooms/{roomId}/chatmessages/")
    public List<ChatMessage> getAllMessagesInRoom(@PathVariable long roomId){
        return chatMessageRepository.findAll();
    }

    @GetMapping("chatrooms/{roomId}/chatmessages/{id}")
    public Optional<ChatMessage> getMessageByIdInRoom(@PathVariable long roomId,@PathVariable long id){
        return chatMessageRepository.findById(id);
    }

    @PostMapping(value = "chatrooms/{roomId}/chatmessages/")
    public ChatMessage postNewMessageInRoom(@PathVariable long roomId, @RequestBody ChatMessage chatMessage){
        chatMessage.setChatRoom(chatRoomRepository.findById(roomId).get());
        return chatMessageRepository.save(chatMessage);
    }
}
