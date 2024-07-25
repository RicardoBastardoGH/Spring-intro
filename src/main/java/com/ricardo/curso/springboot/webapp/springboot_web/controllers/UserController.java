package com.ricardo.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ricardo.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Ricardo", "Bastardo","asd@correo.com");
        
        model .addAttribute("title", "Hola Mundo Spring Boot 2.3.0");
        model .addAttribute("user", user);

        return ("details");
    }

}
