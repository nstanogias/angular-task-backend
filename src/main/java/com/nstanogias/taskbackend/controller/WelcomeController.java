package com.nstanogias.taskbackend.controller;

import com.nstanogias.taskbackend.model.WelcomeBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelcomeController {

    @GetMapping(path = "/welcome")
    public WelcomeBean getWelcomeMessage() {
        return new WelcomeBean("Welcome");
    }

    @GetMapping(path = "/welcome/{name}")
    public WelcomeBean getWelcomeMessageParameter(@PathVariable String name) {
        return new WelcomeBean("Welcome " + name);
    }
}
