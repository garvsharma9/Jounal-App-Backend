package com.journal.journalApp.Services;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    private EmailService emailService;
    @Disabled
    @Test
     void testSendMail(){
        emailService.sendEmail("garvsharma9090@gmail.com", "Testing java mail sender", "Hi, this is java mail sender");
    }
}
