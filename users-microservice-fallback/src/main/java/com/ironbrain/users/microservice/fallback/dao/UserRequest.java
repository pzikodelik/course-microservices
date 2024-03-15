package com.ironbrain.users.microservice.fallback.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest {

    private Long id;
    private String name;
    private String email;
    private Integer age;

}
