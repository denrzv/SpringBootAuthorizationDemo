package io.github.denrzv.springauthorizationdemo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    @NotBlank
    @Size(min = 4, max = 10)
    private final String user;
    @NotBlank
    @Size(min = 8, max = 16)
    private final String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return user.equals(user1.user) && password.equals(user1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }
}
