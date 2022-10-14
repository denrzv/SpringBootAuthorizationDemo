package io.github.denrzv.springauthorizationdemo.repository;

import io.github.denrzv.springauthorizationdemo.model.Authorities;
import io.github.denrzv.springauthorizationdemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<User, List<Authorities>> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    public User addUser(String user, String password, List<Authorities> authorities) {
        User newUser = new User(user, password);
        users.put(newUser, authorities);
        return newUser;
    }

    public List<Authorities> getUserAuthorities(User user) {
        return users.getOrDefault(user, new ArrayList<>());
    }
}
