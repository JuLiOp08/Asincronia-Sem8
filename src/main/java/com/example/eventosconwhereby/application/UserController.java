package com.example.eventosconwhereby.application;

import com.example.eventosconwhereby.domain.User;
import com.example.eventosconwhereby.domain.WelcomeEmailEvent;
import com.example.eventosconwhereby.infrastrucutre.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public UserController(UserRepository userRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userRepository.save(user);
        applicationEventPublisher.publishEvent(new WelcomeEmailEvent(this, savedUser.getEmail(), savedUser.getName()));
        return ResponseEntity.ok(savedUser);
    }

}
