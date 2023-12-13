package com.playwith.play.initData;

import com.playwith.play.user.UserService;
import lombok.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {
    @Bean
    public ApplicationRunner init(UserService userService) {
        return args -> {
            userService.join("admin", "1234", "admin", "");

            IntStream.rangeClosed(1, 3).forEach(i -> {
                userService.join("user" + i, "1234", "nickname" + i, "");
            });
        };
    }
}