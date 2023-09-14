package com.myproject.awssqs.service;

import com.myproject.awssqs.dto.NotificationDto;
import com.myproject.awssqs.mapper.NotificationMapper;
import com.myproject.awssqs.repository.NotificationRepository;
import com.myproject.awssqs.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final RecipientRepository recipientRepository;
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public Mono<NotificationDto> findNotificationByUid(String uid) {
        return notificationRepository.findById(uid)
                .map(notificationMapper::map);
    }
    public Mono<NotificationDto> findNotificationWithRecipientByUid(String uid) {
        return notificationRepository.findById(uid)
                .flatMap(notificationEntity -> recipientRepository.findById(notificationEntity.getRecipientUid())
                .map(recipientEntity -> {
                    notificationEntity.setRecipient(recipientEntity);
                    return notificationEntity;
                }).map(notificationMapper::map));
    }
}
