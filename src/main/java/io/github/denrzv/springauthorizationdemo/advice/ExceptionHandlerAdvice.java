package io.github.denrzv.springauthorizationdemo.advice;

import io.github.denrzv.springauthorizationdemo.exception.InvalidCredentials;
import io.github.denrzv.springauthorizationdemo.exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ResponseBody
    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidCredentialsHandler(InvalidCredentials e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String unauthorizedUserHandler(UnauthorizedUser e) {
        return e.getMessage();
    }
}
