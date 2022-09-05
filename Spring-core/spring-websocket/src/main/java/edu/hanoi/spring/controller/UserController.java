package edu.hanoi.spring.controller;

import edu.hanoi.spring.model.Message;
import edu.hanoi.spring.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class UserController {
    @MessageMapping("/user")
    @SendTo("/topic/chat")
    public Message add(User user){
        System.out.println("user: "+user.getUsername() +"-email "+user.getEmail());
        return new Message(user.getUsername());
    }
}
