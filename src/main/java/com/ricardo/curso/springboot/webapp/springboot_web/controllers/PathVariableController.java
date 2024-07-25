package com.ricardo.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.curso.springboot.webapp.springboot_web.models.User;
import com.ricardo.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    
    @Value("${config.code}")
    private Integer code;
    @Value("${config.username}")
    private String username;
    @Value("${config.message}")
    private String message;
    @Value("${config.listOfValues}")
    private String[] listOfValues;
    @Value("#{'${config.listOfValues}'.split(',')}")
    private String[] valueList;

    @Value("#{'${config.listOfValues}'}")
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
    
    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private String price;


    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {

        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVariable(@PathVariable String product, @PathVariable Long id) {
        
        Map<String, Object> body = new HashMap<>();
        body.put("product", product);
        body.put("id", id);
        return body;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value ("${config.message}") String message) {
        
        Long code2 = environment.getProperty("config.code", Long.class);

        Map<String, Object> body = new HashMap<>();
        body.put("code", code);
        body.put("code2", code2);
        body.put("username", username);
        body.put("message", message);
        body.put("message2", environment.getProperty("config.message"));
        body.put("listOfValues", listOfValues);
        body.put("valueList", valueList);
        body.put("valueString", valueString);
        body.put("valuesMap", valuesMap);
        body.put("product", product);
        body.put("price", price);
        return body;
    }

}
