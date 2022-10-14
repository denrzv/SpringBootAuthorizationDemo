package io.github.denrzv.springauthorizationdemo.controller;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UserParser {
}
