package com.example.eventosconwhereby.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEmailListener {

    final private EmailService emailService;

    public WelcomeEmailListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    @Async
    public void sendWelcomeEmail(WelcomeEmailEvent welcomeEmailEvent) {
        emailService.sendEmail(welcomeEmailEvent.getEmail(), "Bienvenido", "Hola " + welcomeEmailEvent.getName() + ", bienvenido a nuestra plataforma.");
    }
}
