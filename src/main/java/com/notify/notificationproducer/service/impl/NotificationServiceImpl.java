package com.notify.notificationproducer.service.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.notify.notificationproducer.dto.GroupMessage;
import com.notify.notificationproducer.dto.NotificationPriority;
import com.notify.notificationproducer.dto.NotificationRequest;
import com.notify.notificationproducer.service.contract.NotificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final KafkaTemplate<String, GroupMessage> kafkaTemplate;

    public void putEvent(NotificationRequest request) {

        GroupMessage groupMessage = GroupMessage.builder()
        .messageId(request.getMessageId())
        .content(request.getContent())
        .priority(request.getPriority())
        .groupId(request.getGroupId())
        .groupTitle(request.getGroupTitle())
        .userIds(request.getUserIds())
        .build();

        String topic = request.getPriority() == NotificationPriority.HIGH 
            ? "notifications.high" 
            : "notifications.medium";

        kafkaTemplate.send(topic, groupMessage);
    }
}
