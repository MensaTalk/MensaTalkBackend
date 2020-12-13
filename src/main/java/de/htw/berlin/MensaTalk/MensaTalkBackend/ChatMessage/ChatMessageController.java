package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomRepository;
import de.htw.berlin.jwt.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ChatMessageController {
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private UserDao userDao;

    // Direkter Zugriff
    @GetMapping("/chatmessages")
    public List<ChatMessage> getAllMessages() {
        return chatMessageRepository.findAll();
    }

    @GetMapping("/chatmessages/{id}")
    public Optional<ChatMessage> getMessageById(@PathVariable long id) {
        return chatMessageRepository.findById(id);
    }

    @PostMapping(value = "/chatmessages")
    public List<ChatMessage> postNewMessage(@RequestBody List<ChatMessageDTO> chatMessageListDTO) {
        List<ChatMessage> newMessages = new ArrayList<>(        );

        for(ChatMessageDTO chatMessageDTO :chatMessageListDTO ) {
            ChatMessage newMessage = new ChatMessage();
            Optional<ChatRoom> room = chatRoomRepository.findById(chatMessageDTO.getChatRoomId());
            if (room.isPresent()) {
                newMessage.setChatRoom(room.get());
            } else {
                //TODO: Errorhandling!
                return null;
            }

            newMessage.setCreated_at(chatMessageDTO.getCreated_at());
            newMessage.setTextMessage(chatMessageDTO.getTextMessage());
            newMessage.setAuthor(userDao.findByUsername(chatMessageDTO.getAuthorName()));

            newMessages.add(newMessage);
        }
        return chatMessageRepository.saveAll(newMessages);
    }

    // In Abhängigkeit zum Raum
    @GetMapping("/chatrooms/{roomId}/chatmessages")
    public List<ChatMessage> getAllMessagesInRoom(@PathVariable long roomId) {
        return chatMessageRepository.findByChatRoomId(roomId);
    }

}
