package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.MessengerTwilioAdapter;
import com.pragma.powerup.usermicroservice.domain.api.IMessageTwilioServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IMessageTwilioPersistencePort;
import com.pragma.powerup.usermicroservice.domain.usecase.MessageUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public IMessageTwilioPersistencePort messageTwilioPersistencePort(){
        return new MessengerTwilioAdapter();
    }

    @Bean
    public IMessageTwilioServicePort messageTwilioServicePort(){
        return new MessageUseCase(messageTwilioPersistencePort());
    }

}
