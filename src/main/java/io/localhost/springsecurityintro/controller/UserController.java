package io.localhost.springsecurityintro.controller;

import io.localhost.springsecurityintro.model.MyUser;
import io.localhost.springsecurityintro.service.MyUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final MyUserService myUserService;



    @PostMapping("/register")
    public MyUser register(@RequestBody MyUser user){
        return myUserService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody MyUser user){
        log.info(user.toString());
        return myUserService.verify(user);
    }

}
