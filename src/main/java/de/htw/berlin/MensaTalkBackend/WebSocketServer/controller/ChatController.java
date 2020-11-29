package de.htw.berlin.MensaTalkBackend.WebSocketServer.controller;


import de.htw.berlin.MensaTalkBackend.WebSocketServer.model.SocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public SocketMessage sendMessage(@Payload SocketMessage socketMessage) {
        return socketMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public SocketMessage addUser(@Payload SocketMessage socketMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", socketMessage.getSender());
        return socketMessage;
    }

}