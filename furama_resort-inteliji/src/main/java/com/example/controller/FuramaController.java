package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller
public class FuramaController {

    @GetMapping(value = "")
    public String goHome() {
        return "common/home";
    }

}
