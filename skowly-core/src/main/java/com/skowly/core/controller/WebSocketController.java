package com.skowly.core.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

class Message {
    private String username;
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

@Controller
public class WebSocketController {

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public Message broadcastMessage(Message message) {
        return message;
    }
}
