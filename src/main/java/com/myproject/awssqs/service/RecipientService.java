package com.myproject.awssqs.service;

import com.myproject.awssqs.dto.RecipientDto;
import com.myproject.awssqs.entity.NotificationEntity;
import com.myproject.awssqs.entity.RecipientEntity;
import com.myproject.awssqs.mapper.RecipientMapper;
import com.myproject.awssqs.repository.NotificationRepository;
import com.myproject.awssqs.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final RecipientRepository recipientRepository;
    private final NotificationRepository notificationRepository;
    private final RecipientMapper recipientMapper;

    public Mono<RecipientDto> findRecipientWithNotificationsByUid(String uid) {
        return Mono.zip(recipientRepository.findById(uid),
                notificationRepository.findAllByRecipientUid(uid).collectList())
                .map(tuples -> {
                    RecipientEntity recipientEntity = tuples.getT1();
                    List<NotificationEntity> notifications = tuples.getT2();
                    recipientEntity.setNotifications(notifications);
                    return recipientMapper.map(recipientEntity);
                });
    }
}
