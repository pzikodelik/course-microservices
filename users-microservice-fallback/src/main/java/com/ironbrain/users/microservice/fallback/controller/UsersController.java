package com.ironbrain.users.microservice.fallback.controller;

import brave.Tracer;
import com.ironbrain.users.microservice.fallback.dao.UserResponse;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@AllArgsConstructor
@RequestMapping("/fallback/users")
public class UsersController {

    private final Environment env;

    private final Tracer tracer;

    @Timed(value = "users.fallback.get.user")
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUser() {

        String message = String.format("FALLBACK- Retrieving User info from %s class, method %s",
                UsersController.class.getSimpleName(),
                "getUser()");

        log.info(message);

        tracer.currentSpan().tag("message.controller.info", message);

        return new ResponseEntity<>(
                UserResponse
                        .builder()
                        .id(env.getProperty("application.user.id"))
                        .name(env.getProperty("application.user.name"))
                        .email(env.getProperty("application.user.email"))
                        .age(env.getProperty("application.user.age"))
                        .build(),
                HttpStatus.OK
        );
    }
}
