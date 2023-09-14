package com.myproject.awssqs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record NotificationDto(String id,
                              String subject,
                              String text,
                              String recipientUid,
                              RecipientDto recipient) {
}
