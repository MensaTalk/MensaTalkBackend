package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomRepository;
import de.htw.berlin.jwt.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<ChatMessageDTO> getAllMessages() {
        return chatMessageRepository.findAll().parallelStream().map(ChatMessage::createDTO).collect(Collectors.toList());
    }

    @GetMapping("/chatmessages/{id}")
    public Optional<ChatMessageDTO> getMessageById(@PathVariable long id) {
        return chatMessageRepository.findById(id).map(ChatMessage::createDTO);
    }

    @PostMapping(value = "/chatmessages")
    public List<ChatMessageDTO> postNewMessage(@RequestBody List<ChatMessageDTO> chatMessageListDTO) {
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
        return chatMessageRepository.saveAll(newMessages).parallelStream().map(ChatMessage::createDTO).collect(Collectors.toList());
    }

    // In Abhängigkeit zum Raum
    @GetMapping("/chatrooms/{roomId}/chatmessages")
    public List<ChatMessageDTO> getAllMessagesInRoom(@PathVariable long roomId) {
        return chatMessageRepository.findByChatRoomId(roomId).parallelStream().map(ChatMessage::createDTO).collect(Collectors.toList());
    }

}
