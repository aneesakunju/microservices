package com.aneesakunju.shuffle_service.controller;

import com.aneesakunju.shuffle_service.model.CreateShuffleRequest;
import com.aneesakunju.shuffle_service.service.LogService;
import com.aneesakunju.shuffle_service.service.ShuffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShuffleController {

    private final ShuffleService shuffleService;
    private final LogService logService;

    public ShuffleController(ShuffleService shuffleService, LogService logService) {
        this.shuffleService = shuffleService;
        this.logService = logService;
    }

    @RequestMapping("/shuffle")
    //@PostMapping("/shuffle")
    public ResponseEntity<?> create(@RequestBody CreateShuffleRequest request) {
        int number;
        try {
            number = Integer.parseInt(request.number());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Input is not a valid number" + request);

        }
        if (number < 1 || number > 1000) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid input. Enter a number between 1 and 1000.");
        }

        logService.logRequest(request);

        try {
            List<Integer> list = shuffleService.shuffle(number);
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: Unable to generate list of numbers.");
        }



    }
}

