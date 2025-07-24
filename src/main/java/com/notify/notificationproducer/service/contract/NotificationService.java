package com.notify.notificationproducer.service.contract;

import com.notify.notificationproducer.dto.NotificationRequest;

public interface NotificationService {
    void putEvent(NotificationRequest request);
}
