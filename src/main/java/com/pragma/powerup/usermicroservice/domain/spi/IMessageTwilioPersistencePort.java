package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Messenger;

public interface IMessageTwilioPersistencePort {
    void sendMessage(Messenger messenger);

}
