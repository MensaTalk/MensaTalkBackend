package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class ChatUserController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from UserController!";
    }
}
