package com.emirhanuzun.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // Need a controller method to read form data and
    // Add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // Read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // Convert that data to all caps
        theName = theName.toUpperCase();

        // Create the message
        String result = "Yo! " + theName;

        // Add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }
}
