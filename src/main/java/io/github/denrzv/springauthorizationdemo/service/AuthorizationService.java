package io.github.denrzv.springauthorizationdemo.service;

import io.github.denrzv.springauthorizationdemo.exception.InvalidCredentials;
import io.github.denrzv.springauthorizationdemo.exception.UnauthorizedUser;
import io.github.denrzv.springauthorizationdemo.model.Authorities;
import io.github.denrzv.springauthorizationdemo.model.User;
import io.github.denrzv.springauthorizationdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }
}