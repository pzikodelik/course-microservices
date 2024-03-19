package com.ironbrain.users.microservice.controller;

import brave.Tracer;
import com.ironbrain.users.microservice.dao.UserResponse;
import com.ironbrain.users.microservice.service.UserService;
import com.ironbrain.users.microservice.service.impl.UserServiceImpl;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    private final Tracer tracer;

    @Timed(value = "users.get.user")
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUser() {

        String message = String.format("Retrieving User info from %s class, method %s",
                UsersController.class.getSimpleName(),
                "getUse()");

        log.info(message);

        tracer.currentSpan().tag("message.controller.info", message);

        return new ResponseEntity<>(
                userService.getUser(),
                HttpStatus.OK
        );
    }
}
