# springsecurity6intro


SecurityConfig.java
```java

package io.localhost.springsecurityintro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // 1
        //httpSecurity.csrf(customizer -> customizer.disable());
        //httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated()); // any request to Be Authenticated
        //httpSecurity.formLogin(Customizer.withDefaults()); // login form web
        //httpSecurity.httpBasic(Customizer.withDefaults()); // http basic Ex Postman
        //httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // application stateless

        /*
        Customizer<CsrfConfigurer<HttpSecurity>> customizerCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
                httpSecurityCsrfConfigurer.disable();
            }
        };

        httpSecurity.csrf(customizerCsrf);
            =
        httpSecurity.csrf(customizer -> customizer.disable());
        */

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
    }

}



```