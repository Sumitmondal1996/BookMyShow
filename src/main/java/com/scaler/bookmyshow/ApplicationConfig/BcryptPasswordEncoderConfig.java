package com.scaler.bookmyshow.ApplicationConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BcryptPasswordEncoderConfig {
    @Bean
    public BCryptPasswordEncoder BcryptPasswordEncoder() {
        return  new BCryptPasswordEncoder();
    }
}
