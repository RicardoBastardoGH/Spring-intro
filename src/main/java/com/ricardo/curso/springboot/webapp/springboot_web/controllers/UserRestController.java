package com.ricardo.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.curso.springboot.webapp.springboot_web.models.User;
import com.ricardo.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() {

        User user = new User("Ricardo", "Bastardo","asd@correo.com");
        UserDto userDto = new UserDto();
        userDto.setTitle("Hola Mundo Spring Boot 2.3.0");
        userDto.setUser(user);

        return userDto;
    }


    @GetMapping("/list")
    public List<User> list() {

        User user1 = new User("Ricardo", "Bastardo","asd@correo.com");
        User user2 = new User("Pepe", "Guzman","asd@correo.com");
        User user3 = new User("Jhon", "Doe","asd@correo.com");

        List <User> users = Arrays.asList(user1, user2, user3);
        // List<User> users = List.of(user1, user2, user3);

        return users;    
    }


    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {

        User user = new User("Ricardo", "Bastardo","asd@correo.com");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot 2.3.0");
        body.put("user", user);

        return body;
    }

}
