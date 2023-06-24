package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.domain.model.Messenger;
import com.pragma.powerup.usermicroservice.domain.spi.IMessageTwilioPersistencePort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class MessengerTwilioAdapter implements IMessageTwilioPersistencePort {

    private String ACCOUNT_SID = "AC0079d0c1818e6f801bb4e278a7689e16";
    private String AUTH_TOKEN = "88f2864eb8d7272d30778539f8df8d1b";
    private final String MESSAGE = "Your order is ready! Use this pin to claim it: " + "Thanks.";


    @Override
    public void sendMessage(Messenger messenger) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(
                new com.twilio.type.PhoneNumber(messenger.getPhoneClient()),
                new com.twilio.type.PhoneNumber(messenger.getPhoneSender()),
                MESSAGE+messenger.getPin()).create();

    }

}
