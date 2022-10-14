package io.github.denrzv.springauthorizationdemo.controller;

import io.github.denrzv.springauthorizationdemo.model.Authorities;
import io.github.denrzv.springauthorizationdemo.model.User;
import io.github.denrzv.springauthorizationdemo.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@UserParser @Valid User user) {
        return service.getAuthorities(user);
    }
}
