package com.notify.notificationproducer.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notify.notificationproducer.dto.NotificationRequest;
import com.notify.notificationproducer.service.contract.NotificationService;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final NotificationService notificationservice;


    @PostMapping("/notify")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        notificationservice.putEvent(request);

        return ResponseEntity.ok(
            "The message was sent to the broker"
        );
    }
}