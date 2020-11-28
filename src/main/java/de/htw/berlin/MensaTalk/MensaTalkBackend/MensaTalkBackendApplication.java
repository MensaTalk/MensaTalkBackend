package de.htw.berlin.MensaTalk.MensaTalkBackend;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomRepository;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser.ChatUser;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser.ChatUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MensaTalkBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MensaTalkBackendApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(ChatRoomRepository chatRoomRepository, ChatUserRepository chatUserRepository) {
        return args -> {
            //Create 3 Rooms
            chatRoomRepository.save(new ChatRoom(0l, "testRoom1", null, null));
            chatRoomRepository.save(new ChatRoom(1l, "testRoom1", null, null));
            chatRoomRepository.save(new ChatRoom(2l, "testRoom2", null, null));

            //Create 3 Users
            chatUserRepository.save(new ChatUser(0l, "Steven", null, null));
            chatUserRepository.save(new ChatUser(1l, "Oliver", null, null));
            chatUserRepository.save(new ChatUser(2l, "Tilman", null, null));


        };
    }
}
