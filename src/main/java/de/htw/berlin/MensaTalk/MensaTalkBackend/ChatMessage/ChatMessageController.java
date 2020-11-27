package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ChatMessage")
public class ChatMessageController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from ChatMessageController!";
    }
}
