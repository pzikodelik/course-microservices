package com.ironbrain.users.microservice.service.impl;

import brave.Tracer;
import com.ironbrain.users.microservice.dao.UserResponse;
import com.ironbrain.users.microservice.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final Environment env;

    private final Tracer tracer;

    @Override
    public UserResponse getUser() {

        String message = String.format("Retrieving User info from %s class, method %s",
                UserServiceImpl.class.getSimpleName(),
                "getUser()");

        log.info(message);

        tracer.currentSpan().tag("message.service.info", message);

        return UserResponse
                .builder()
                .id(env.getProperty("application.user.id"))
                .name(env.getProperty("application.user.name"))
                .email(env.getProperty("application.user.email"))
                .age(env.getProperty("application.user.age"))
                .build();
    }
}
