package com.notify.notificationproducer.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class GroupMessage {
    private Long messageId;
    private String content;
    private NotificationPriority priority;
    private Long groupId;
    private String groupTitle;
    private List<Long> userIds; 
}
