package com.emirhanuzun.springboot.demosecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        //return "plain-login";
        return "fancy-login";
    }

    // Add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        //return "plain-login";
        return "access-denied";
    }



}
