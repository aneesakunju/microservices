package com.aneesakunju.log_service.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogServiceController {

    Logger logger = LoggerFactory.getLogger(LogServiceController.class);

    public record CreateShuffleRequest(String number) {
    }

    @PostMapping("/log")
    public ResponseEntity<?> log(@RequestBody CreateShuffleRequest shuffleRequest) {
        logger.info("Received shuffle request of " + shuffleRequest.number());
        return ResponseEntity.ok().body("");
    }
}
