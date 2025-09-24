package io.localhost.springsecurityintro.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {


    @GetMapping
    public String home(HttpServletRequest request){
        return "Welcome To Spring" + request.getSession().getId();
    }


}
