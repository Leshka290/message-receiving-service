package com.myproject.awssqs.rest;

import com.myproject.awssqs.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{uid}")
    public Mono<?> findNotificationByUid(@PathVariable String uid) {
        return notificationService.findNotificationByUid(uid);
    }

    @GetMapping("/recipient/{uid}")
    public Mono<?> findNotificationWithRecipientByUid(@PathVariable String uid) {
        return notificationService.findNotificationWithRecipientByUid(uid);
    }
}
