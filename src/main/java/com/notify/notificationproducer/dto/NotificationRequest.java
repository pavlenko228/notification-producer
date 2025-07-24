package com.notify.notificationproducer.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class NotificationRequest {

    @NotBlank(message = "MessageId cannot be empty")
    private Long messageId;

    @NotBlank(message = "Message cannot be empty")
    private String content;
    
    @NotNull(message = "Priority cannot be null")
    private NotificationPriority priority;
    
    @NotBlank(message = "Group ID cannot be empty")
    private Long groupId;
    
    @NotBlank(message = "Group title cannot be empty")
    private String groupTitle;
    
    @NotEmpty(message = "User IDs list cannot be empty")
    private List<Long> userIds;
}