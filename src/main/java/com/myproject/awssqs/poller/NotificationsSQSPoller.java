package com.myproject.awssqs.poller;

import com.myproject.awssqs.dto.NotificationDto;
import com.myproject.awssqs.entity.NotificationEntity;
import com.myproject.awssqs.mapper.NotificationMapper;
import com.myproject.awssqs.repository.NotificationRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationsSQSPoller {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMassage(@Payload NotificationDto message) {
        log.info("received notification : {}", message);
        NotificationEntity entity = notificationMapper.map(message);
        notificationRepository.save(entity).subscribe();
    }
}
