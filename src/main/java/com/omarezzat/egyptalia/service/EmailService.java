package com.omarezzat.egyptalia.service;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;
import com.omarezzat.egyptalia.DTO.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    public ResponseEntity<Object> sendEmail(EmailRequest emailRequest) {
        Email email = new Email();
        email.setFrom("Egyptalia", "MS_49URh8@trial-o65qngk1yxdlwr12.mlsender.net ");
        email.addRecipient("Name", emailRequest.to());
        email.setSubject(emailRequest.subject());
        email.setPlain(emailRequest.body());
        MailerSend ms = new MailerSend();
        ms.setToken("mlsn.b217024fe67d0d14e0fc0d2c908ed1578a832e7d9f07d2017ed150835ba50050");
        try {
            ms.emails().send(email);
            return ResponseEntity.ok().body("Email Sent Successfully");
        } catch (MailerSendException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
