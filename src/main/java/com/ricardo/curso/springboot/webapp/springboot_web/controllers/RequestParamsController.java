package com.ricardo.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.ricardo.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto params(@RequestParam(required = false, name = "message") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message == null ? "Hola" : message);
        return paramDto;
    }
    
    @GetMapping("/bar")
    public ParamMixDto params(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamMixDto params(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        ParamMixDto params = new ParamMixDto();
        params.setMessage(request.getParameter("message"));
        params.setCode(code);
        return params;
    }   

}
