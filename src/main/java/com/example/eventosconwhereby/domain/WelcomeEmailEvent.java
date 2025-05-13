package com.example.eventosconwhereby.domain;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class WelcomeEmailEvent extends ApplicationEvent {
    private final String email;
    private final String name;

    public WelcomeEmailEvent(Object source, String email, String name) {
        super(source);
        this.email = email;
        this.name = name;
    }
}
