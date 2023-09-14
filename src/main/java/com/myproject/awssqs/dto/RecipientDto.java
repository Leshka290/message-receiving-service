package com.myproject.awssqs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RecipientDto(String id,
                           String channel,
                           String address,
                           String fullName,
                           List<NotificationDto> notifications) {

}
