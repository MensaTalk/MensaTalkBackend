package de.htw.berlin.MensaTalkBackend.WebSocketServer.model;

public class SocketMessage {
    private String text;
    private String from;

    public SocketMessage(String content, String from) {
        this.text = content;
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public String getFrom() {
        return from;
    }

}

