package com.pragma.powerup.usermicroservice.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.powerup.usermicroservice.domain.model.Messenger;

public class MessageService {

    public static Messenger deserializableJsonSms(String messageJson){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(messageJson,Messenger.class);
        } catch (JsonProcessingException e) {
            System.err.println("Mistake to serialize: " + e.getMessage());
            return null;
        }
    }
}
