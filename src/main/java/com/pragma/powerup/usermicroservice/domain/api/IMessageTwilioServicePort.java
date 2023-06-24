package com.pragma.powerup.usermicroservice.domain.api;

public interface IMessageTwilioServicePort {
    void sendMessage(String messengerSms);
}
