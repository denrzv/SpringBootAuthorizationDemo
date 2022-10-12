package io.github.denrzv.springauthorizationdemo.repository;

import io.github.denrzv.springauthorizationdemo.model.Authorities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Configuration
class UserRepositoryLoad {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryLoad.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.addUser("ruser", "password",
                    new ArrayList<>(Collections.singletonList(Authorities.READ))));
            log.info("Preloading " + repository.addUser("rwuser", "password",
                    new ArrayList<>(Arrays.asList(Authorities.READ, Authorities.WRITE))));
            log.info("Preloading " + repository.addUser("rwduser", "password",
                    new ArrayList<>(Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE))));
        };
    }
}