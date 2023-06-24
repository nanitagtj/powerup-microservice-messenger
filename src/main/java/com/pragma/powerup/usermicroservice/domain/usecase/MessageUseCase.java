package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IMessageTwilioServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IMessageTwilioPersistencePort;

import static com.pragma.powerup.usermicroservice.domain.services.MessageService.deserializableJsonSms;

public class MessageUseCase implements IMessageTwilioServicePort {
    private final IMessageTwilioPersistencePort messageTwilioPersistencePort;

    public MessageUseCase(IMessageTwilioPersistencePort messageTwilioPersistencePort) {
        this.messageTwilioPersistencePort = messageTwilioPersistencePort;
    }

    @Override
    public void sendMessage(String messengerSms) {
        messageTwilioPersistencePort.sendMessage(deserializableJsonSms(messengerSms));
    }
}
