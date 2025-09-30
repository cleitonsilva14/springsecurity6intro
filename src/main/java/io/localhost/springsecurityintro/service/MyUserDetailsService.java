package io.localhost.springsecurityintro.service;


import io.localhost.springsecurityintro.model.MyUser;
import io.localhost.springsecurityintro.model.User;
import io.localhost.springsecurityintro.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {


    private final MyUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser user = userRepository.findByUsername(username);

        if(user == null){
            log.warn("User not found!");
            throw new UsernameNotFoundException("User not found!");
        }

        return new User(user);

    }
}
