package com.myproject.awssqs.rest;

import com.myproject.awssqs.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipients")
public class RecipientController {

    private final RecipientService recipientService;

    @GetMapping("/{uid}")
    public Mono<?> findNotificationByUid(@PathVariable String uid) {
        return recipientService.findRecipientWithNotificationsByUid(uid);
    }
}
