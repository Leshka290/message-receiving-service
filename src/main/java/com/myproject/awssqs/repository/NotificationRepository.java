package com.myproject.awssqs.repository;

import com.myproject.awssqs.entity.NotificationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotificationRepository extends R2dbcRepository<NotificationEntity, String> {
}
