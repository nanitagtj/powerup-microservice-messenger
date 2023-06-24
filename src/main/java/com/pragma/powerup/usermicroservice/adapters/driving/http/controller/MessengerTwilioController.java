package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IMessageHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.configuration.Constants.MESSAGE_SENT;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessengerTwilioController {

    private final IMessageHandler messageHandler;

    @Operation(summary = "Notify",
            responses = {
                    @ApiResponse(responseCode = "200", description = MESSAGE_SENT,
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
            })
    @PostMapping("/pin")
    public ResponseEntity<Map<String, String>> sendSms(@RequestBody String messengerSms) {
        messageHandler.sendMessage(messengerSms);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,MESSAGE_SENT));
    }
}
