package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chatusers")
public class ChatUserController {

    @Autowired
    private ChatUserRepository chatUserRepository;

    @RequestMapping("/")
    public List<ChatUser> getUsers(){
        return chatUserRepository.findAll();
    }
    @RequestMapping("/{id}")
    public Optional<ChatUser> getUserById(@PathVariable long id){
       return chatUserRepository.findById(id);
    }
}
