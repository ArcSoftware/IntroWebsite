package com.theironyard.charlotte.IntroWebsite.services;

import com.theironyard.charlotte.IntroWebsite.entities.Message;
import com.theironyard.charlotte.IntroWebsite.entities.User;
import com.theironyard.charlotte.IntroWebsite.repositories.MessageRepo;
import com.theironyard.charlotte.IntroWebsite.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    UserRepo users;
    MessageRepo messages;


    public MessageService(UserRepo users, MessageRepo messages) {
        this.users = users;
        this.messages = messages;
    }

    public void createMessage(String user, String text) {
        User existingUser = users.findFirstByUsername(user);
        Message message = new Message(existingUser, text);
        messages.save(message);
    }
}
