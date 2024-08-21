package com.omarezzat.egyptalia.controller;

import com.omarezzat.egyptalia.DTO.EmailRequest;
import com.omarezzat.egyptalia.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/mail")
public class EmailController {
    private final EmailService emailService;

    @PostMapping("send")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> sendEmail(@RequestBody EmailRequest emailRequest) {
        return emailService.sendEmail(emailRequest);
    }
}
