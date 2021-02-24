package br.com.vaptzupt.vacinacao.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ClientController {

    @GetMapping
    public String test(@RequestParam(defaultValue = "world!") String name) {
        return "Hello " + name;
    }

}
