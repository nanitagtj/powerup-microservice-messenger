package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IMessageHandler;
import com.pragma.powerup.usermicroservice.domain.api.IMessageTwilioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageHandlerImpl implements IMessageHandler {

    private final IMessageTwilioServicePort messageTwilioServicePort;
    @Override
    public void sendMessage(String messengerSms) {
        messageTwilioServicePort.sendMessage(messengerSms);
    }
}
