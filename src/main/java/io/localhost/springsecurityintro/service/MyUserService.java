package io.localhost.springsecurityintro.service;


import io.localhost.springsecurityintro.model.MyUser;
import io.localhost.springsecurityintro.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);


    public MyUser register(MyUser myUser){
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        return myUserRepository.save(myUser);
    }

}
