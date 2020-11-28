package de.htw.berlin.MensaTalk.MensaTalkBackend;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoomRepository;
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
    ApplicationRunner applicationRunner(ChatRoomRepository chatRoomRepository) {
        return args -> {
            //Create 3 Rooms
            chatRoomRepository.save(new ChatRoom(1l, "testRoom1", null));
            chatRoomRepository.save(new ChatRoom(2l, "testRoom2", null));
            chatRoomRepository.save(new ChatRoom(3l, "testRoom1", null));




        };
    }
}
