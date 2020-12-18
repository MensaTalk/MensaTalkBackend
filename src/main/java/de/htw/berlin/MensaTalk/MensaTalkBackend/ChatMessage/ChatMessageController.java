package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomRepository;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
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
    private UserRepository userRepository;

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
        List<ChatMessage> newMessages = new ArrayList<>();

        for (ChatMessageDTO chatMessageDTO : chatMessageListDTO) {
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
            newMessage.setAuthor(userRepository.findByUsername(chatMessageDTO.getAuthorName()));

            newMessages.add(newMessage);
        }
        return chatMessageRepository.saveAll(newMessages).parallelStream().map(ChatMessage::createDTO).collect(Collectors.toList());
    }

    // In Abhängigkeit zum Raum
    @GetMapping("/chatrooms/{roomId}/chatmessages")
    public List<ChatMessageDTO> getAllMessagesInRoom(@PathVariable long roomId) {


        ZonedDateTime zonedDateTime =  ZonedDateTime.now().minusMinutes(5);
        Date date = Date.from(zonedDateTime.toInstant());

        return chatMessageRepository.findAllByChatRoomIdAndCreationDateTimeAfter(roomId, date)
                .parallelStream().map(ChatMessage::createDTO)
                .collect(Collectors.toList());
        //.filter(chatMessage -> chatMessage.getCreated_at().after(date2))

    }

}
