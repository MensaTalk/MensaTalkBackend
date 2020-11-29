package de.htw.berlin.MensaTalkBackend.WebSocketServer.controller;


import de.htw.berlin.MensaTalkBackend.WebSocketServer.model.OutputMessage;
import de.htw.berlin.MensaTalkBackend.WebSocketServer.model.SocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(final SocketMessage message) throws Exception {

        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

}