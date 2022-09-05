package edu.hanoi.spring.controller;

import edu.hanoi.spring.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/chat")
    public Message say(Message message, Principal principal){
        return new Message(principal.getName()+ " : "+message.getContent()+"!");
    }
}
